package com.pharmacy.atmycare.ui.LoginFragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pharmacy.atmycare.R;
import com.pharmacy.atmycare.databinding.FragmentATMxLoginBinding;
import com.pharmacy.atmycare.model.ATMX;


public class ATMxLoginFragment extends Fragment {

    private DatabaseReference databaseReference;
    private FragmentATMxLoginBinding binding ;
    private boolean isUserExists = false;
    private boolean isPasswordWrong = true;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        databaseReference = FirebaseDatabase.getInstance().getReference();
        binding = FragmentATMxLoginBinding.inflate(inflater , container , false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnAtmxLogin.setOnClickListener(v->
        {
            if (binding.etAtmXUserId.getText().toString().equals("")) {
                binding.AtmXUserId.setError("Please Fill Valid Username");
            }
            if(binding.etAtmXPassward.getText().toString().equals(""))
            {
                binding.AtmXPassward.setError("Password can't be empty");
            }
            else {
               //checking credentials from server
                ProgressDialog dialog = new ProgressDialog(getContext());
                dialog.setTitle("Please Wait");
                dialog.setMessage("Checking Credentials.....");
                dialog.setCancelable(false);
                dialog.show();
                databaseReference.child("atmxlist").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if(task.getResult().exists())
                        {
                            for(DataSnapshot snapshot : task.getResult().getChildren())
                            {
                                ATMX atmx = snapshot.getValue(ATMX.class);
                                 if(atmx.getUserid().equals(binding.etAtmXUserId.getText().toString()))
                                 {
                                     isUserExists = true;
                                      if(atmx.getPassword().equals(binding.etAtmXPassward.getText().toString()))
                                      {
                                       isPasswordWrong = false;
                                      }
                                      break;
                                 }
                            }

                            if(isUserExists)
                            {
                                if(isPasswordWrong)
                                {
                                    binding.AtmXPassward.setError("Please Enter The Correct Password");
                                    dialog.dismiss();
                                }
                                else
                                {
                                    // Login
                                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Login", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putString("type","Atmx");
                                    editor.putString("username",binding.etAtmXUserId.getText().toString());
                                    editor.putString("password",binding.etAtmXPassward.getText().toString());
                                    editor.commit();
                                    dialog.dismiss();
                                    Navigation.findNavController(LoginFragment.loginView).navigate(LoginFragmentDirections.actionLoginFragmentToATMxDashboardFragment());
                                }
                            }
                            else
                            {
                                binding.AtmXUserId.setError("No ATMx with this User ID");
                                dialog.dismiss();
                            }
                        }
                        else
                        {
                            binding.AtmXUserId.setError("User Doesn't exits with this email Address!!.");
                            dialog.dismiss();
                        }
                    }
                }).addOnCanceledListener(new OnCanceledListener() {
                    @Override
                    public void onCanceled() {
                        Toast.makeText(getContext() , "Please Check Your Internet Connection" , Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext() , e.getMessage() , Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                });
            }
        });
    }
}
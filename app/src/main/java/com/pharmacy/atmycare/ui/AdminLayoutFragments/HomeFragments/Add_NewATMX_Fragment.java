package com.pharmacy.atmycare.ui.AdminLayoutFragments.HomeFragments;

import android.app.ProgressDialog;
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
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pharmacy.atmycare.R;
import com.pharmacy.atmycare.databinding.FragmentAddNewATMXBinding;
import com.pharmacy.atmycare.model.ATMX;
import com.pharmacy.atmycare.ui.AdminLayoutFragments.AdminDashboardFragment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Add_NewATMX_Fragment extends Fragment {

    private FragmentAddNewATMXBinding binding;
    private DatabaseReference databaseRef;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAddNewATMXBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AdminDashboardFragment.bindings.bnAdmin.setVisibility(View.INVISIBLE);
        databaseRef = FirebaseDatabase.getInstance().getReference();
        binding.ibBackFromRegisterNewATMX.setOnClickListener(v->
            Navigation.findNavController(v).navigateUp());

        binding.btnSubmitNewATMX.setOnClickListener(v->
        {
                if (binding.etNewATMXName.getText().toString().isEmpty() || binding.etNewATMXEmail.getText().toString().isEmpty()
                        || binding.etNewATMXPassword.getText().toString().isEmpty() || binding.etNewATMXAddress.getText().toString().isEmpty()
                        || binding.etNewATMXMobileNumber.getText().toString().isEmpty()) {
                    if (binding.etNewATMXName.getText().toString().isEmpty())
                        binding.textInputNameNewATMX.setError("Name Cannot be Empty");
                    if (binding.etNewATMXEmail.getText().toString().isEmpty())
                        binding.textInputEmailNewATMX.setError("Email Cannot be Empty");
                    if (binding.etNewATMXPassword.getText().toString().isEmpty())
                        binding.textInputPasswordNewATMX.setError("Password Cannot be Empty");
                    if (binding.etNewATMXAddress.getText().toString().isEmpty())
                        binding.textInputAddressNewATMX.setError("Address Cannot be Empty");
                    if (binding.etNewATMXMobileNumber.getText().toString().isEmpty())
                        binding.textInputMobileNumberNewATMX.setError("Mobile Number Cannot be Empty");
                } else if (!binding.etNewATMXEmail.getText().toString().contains("@"))
                    binding.textInputEmailNewATMX.setError("Please Enter Valid User Address");
                else if(!binding.cbAddNewATMXFormTermsAndCondition.isChecked())
                    Toast.makeText(getContext(), "Please Accept All Terms And Conditions.", Toast.LENGTH_SHORT).show();
                else {
                    ATMX newATMX = new ATMX(binding.etNewATMXName.getText().toString(), binding.etNewATMXEmail.getText().toString(),
                            binding.etNewATMXPassword.getText().toString(), binding.etNewATMXAddress.getText().toString(),
                            Long.parseLong(binding.etNewATMXMobileNumber.getText().toString()));
                    addNewATMX(newATMX);
                }
        });

    }

    private void addNewATMX(ATMX atmx) {
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Adding ATMx ....");
        progressDialog.setMessage("Please Wait");
        progressDialog.setCancelable(false);
        progressDialog.show();
        final String[] userIDWithoutSpySymbolArr = atmx.getUserid().split("@");
            databaseRef.child("atmxlist").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    boolean canAddNewATMx = true;
                    for (DataSnapshot ds : task.getResult().getChildren()) {
                        if (ds.getKey().equals(userIDWithoutSpySymbolArr[0])) {
                            binding.textInputEmailNewATMX.setError("ATMx exists with given User Id");
                            progressDialog.dismiss();
                            canAddNewATMx = false;
                        }
                    }
                    if (canAddNewATMx) {
                        databaseRef.child("atmxlist").child(userIDWithoutSpySymbolArr[0]).setValue(atmx).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful())
                                {

                                    Toast.makeText(getContext(), "ATMx Added Successfully", Toast.LENGTH_SHORT).show();
                                    progressDialog.dismiss();
                                    Navigation.findNavController(getView()).navigateUp();
                                }
                            }
                        })
                        .addOnCanceledListener(new OnCanceledListener() {
                            @Override
                            public void onCanceled() {
                                progressDialog.dismiss();
                                Toast.makeText(getContext(), "Please Your Internet Connection!!!", Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }
            }).addOnCanceledListener(new OnCanceledListener() {
                @Override
                public void onCanceled() {
                    progressDialog.dismiss();
                    Toast.makeText(getContext(), "Please Your Internet Connection!!!", Toast.LENGTH_LONG).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    databaseRef.child("atmxlist").child(userIDWithoutSpySymbolArr[0]).setValue(atmx).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(getContext(), "ATMx Added Successfully", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                                Navigation.findNavController(getView()).navigateUp();
                            }
                        }
                    })
                            .addOnCanceledListener(new OnCanceledListener() {
                                @Override
                                public void onCanceled() {
                                    progressDialog.dismiss();
                                    Toast.makeText(getContext(), "Please Your Internet Connection!!!", Toast.LENGTH_LONG).show();
                                }
                            });
                }
            });

    }
}
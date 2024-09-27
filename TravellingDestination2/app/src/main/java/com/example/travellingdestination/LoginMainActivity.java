package com.example.travellingdestination;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class LoginMainActivity extends AppCompatActivity {

    public static final String TAG = "TAG";
      EditText mFullName, mEmail, mPassword, mPhone;  // assigning object edit text, button and progress bar
      Button mRegisterBtn;
      FirebaseAuth fAuth;
      ProgressBar progressBar;
      FirebaseFirestore fStore;
      String userID ;



    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);


        // object are link through the id that assign in login xml file

        mFullName = findViewById(R.id.FullName);
        mEmail = findViewById(R.id.Email);
        mPassword = findViewById(R.id.Password);
        mPhone = findViewById(R.id.Phone);
        mRegisterBtn = findViewById(R.id.RegisterBtn);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        progressBar = findViewById(R.id.simpleProgressBar);



        // for checking existing user in account
        if (fAuth.getCurrentUser() != null ){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }





        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {    // saving user typing data into string form


                final String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                final String fullname = mFullName.getText().toString().trim();
                final String phone = mPhone.getText().toString().trim();


                if (TextUtils.isEmpty(fullname)){
                    mFullName.setError("FullName is empty!");
                    return;
                }

                if (TextUtils.isEmpty(email)){  //checking email field is empty or not
                  mEmail.setError("Email is empty!");  // throwing empty  email error message
                  return;
                }

                if (TextUtils.isEmpty(password)){  //checking password field is empty or not
                    mPassword.setError("Password is empty!");  // throwing empty password message
                    return;
                }

                if(TextUtils.isEmpty(phone)){
                    mPhone.setError("phone number is empty!");
                    return;
                }

                if (password.length() <6 ){  // taking condition password length
                    mPassword.setError("Password must be =>6 character");  // if length is not >=6 throw error
                    return;
                }

                progressBar.setVisibility(View.VISIBLE); // making visible progress bar

                // user register into the firebase

                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull final Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(LoginMainActivity.this, "User is created", Toast.LENGTH_SHORT).show();



                            //retrieving register data into fire-base document to make user profile data
                            userID = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fStore.collection("users").document(userID);
                            Map<String, Object> user = new HashMap<>();
                            user.put("fName",fullname);
                            user.put("email", email);
                            user.put("phone", phone);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                            Log.d(TAG, "onSuccess: user profile is created for"+ userID);
                                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                    finish();
                                }
                            });



                        }
                        else {

                            Toast.makeText(LoginMainActivity.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }

                    }
                });


            }
        });



    }


    public void backlogin(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}

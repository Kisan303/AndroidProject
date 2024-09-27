package com.example.travellingdestination;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "TAG";
    EditText mEmail, mPassword;Button mLoginBtn;
    TextView forgetTextLink;
    ProgressBar progressBar;
    FirebaseAuth fAuthh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmail = findViewById(R.id.Email);
        mPassword = findViewById(R.id.Password);
        progressBar = findViewById(R.id.simpleProgressBar);
        fAuthh = FirebaseAuth.getInstance();
        mLoginBtn = findViewById(R.id.loginBtn);
        forgetTextLink = findViewById(R.id.forgetPassword);


        //// Check the user is already login if user already login redirect into homepage

        if (fAuthh.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), Homepage.class));
            finish();
        }



        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();



                if (TextUtils.isEmpty(email)){  //checking email field is empty or not
                    mEmail.setError("Email field is empty!");  // throwing empty  email error message
                    return;
                }

                if (TextUtils.isEmpty(password)){  //checking password field is empty or not
                    mPassword.setError("Password field is empty!");  // throwing empty password message
                    return;
                }




                if (password.length() <6 ){  // taking condition password length
                    mPassword.setError("Password length must be 6 character");  // if length is not >=6 throw error
                    return;
                }

//                  progressBar.setVisibility(View.VISIBLE); // making visible progress bar

                // For Authentication users


                fAuthh.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){

                            // sending verification email\

                            FirebaseUser user = fAuthh.getCurrentUser();

                            user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
//                                    Toast.makeText(MainActivity.this, "Verification email has been send successfully!", Toast.LENGTH_SHORT).show();
                                }
                            }
                            );
//                                    .addOnFailureListener(new OnFailureListener() {
//                                @Override
//                                public void onFailure(@NonNull Exception e) {
//                                    Log.d(TAG, "onFailure: Email is not send" + e.getMessage());
//                                }
//                            });
//

                            Toast.makeText(MainActivity.this, "Login Successful !!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), Homepage.class));
                            finish();


                        }
                        else {

                            Toast.makeText(MainActivity.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();


                        }

//                        progressBar.setVisibility(View.GONE);
                    }
                });

            }
        });


        ///for forget password

        forgetTextLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final EditText restMail = new EditText(v.getContext());
                AlertDialog.Builder passwordResetDailog = new AlertDialog.Builder(v.getContext());
                passwordResetDailog.setTitle("Reset Password !");
                passwordResetDailog.setMessage("Enter your email to reset your password");
                passwordResetDailog.setView(restMail);

                passwordResetDailog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // for extract the email and send rest options links message
                        String mail = restMail.getText().toString();
                        fAuthh.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(MainActivity.this, "Password is reset to your mail", Toast.LENGTH_SHORT).show();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, "There is problem to send rest link" +e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

                passwordResetDailog.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // if user don't want to reset password

                    }
                });

                passwordResetDailog.create().show();

            }
        });

    }
    public void linkregister(View view) {

        startActivity(new Intent(getApplicationContext(), LoginMainActivity.class));
    }


    // skip button for homepage
//
//    public void tohome(View view) {
//
//        startActivity(new Intent(this, Homepage.class ));
//    }
}

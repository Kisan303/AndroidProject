package com.example.travellingdestination;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import javax.annotation.Nullable;

public class DashboardUser extends AppCompatActivity {
    public static final String TAG = "TAG";

    TextView fullnameprofile, emailprofile, numberprofile,verifyMsg;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;
    Button resendCode;
    TextView resetbtn;
    ImageView profileImage;
    ImageView changeProfile;
    ProgressBar progressBar;
    StorageReference storageReference; //  for image upload in  firebase

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_user);

        fullnameprofile = findViewById(R.id.YourName);
        emailprofile = findViewById(R.id.YourEmail);
        numberprofile = findViewById(R.id.YourPhone);
        progressBar = findViewById(R.id.simpleProgressBar);


        resendCode = findViewById(R.id.resendCode);
        verifyMsg = findViewById(R.id.verifyMsg);
        resetbtn = findViewById(R.id.restPassword);


        profileImage = findViewById(R.id.profileImage);
        changeProfile = findViewById(R.id.changeProfile);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        storageReference = FirebaseStorage.getInstance().getReference(); // for profile picture upload reference in firebase
        StorageReference profileRef = storageReference.child("users/"+fAuth.getCurrentUser().getUid()+"/profile.jpg");  // universal profile image for individual users

//      StorageReference profileRef = storageReference.child("profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(profileImage);  // for profile images load in user profile once time save until the profile changes
            }
        });


        userId = fAuth.getCurrentUser().getUid();
        final FirebaseUser user = fAuth.getCurrentUser();



        if (!user.isEmailVerified()){
            verifyMsg.setVisibility(View.VISIBLE);
            resendCode.setVisibility(View.VISIBLE);

            resendCode.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {

                    user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(v.getContext(), "Verification email has been send successful", Toast.LENGTH_SHORT).show();


                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            Log.d(TAG, "onFailure: Email is not send" + e.getMessage());
                        }
                    });

                }
            });
        }

        DocumentReference documentReference = fStore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                fullnameprofile.setText(documentSnapshot.getString("fName"));
                emailprofile.setText(documentSnapshot.getString("email"));
                numberprofile.setText(documentSnapshot.getString("phone"));
            }
        });


        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final EditText restMail = new EditText(v.getContext());
                AlertDialog.Builder passwordResetDailog = new AlertDialog.Builder(v.getContext());
                passwordResetDailog.setTitle("Reset your Password !");
                passwordResetDailog.setMessage("Enter your email for reset password");


                passwordResetDailog.setView(restMail);

                passwordResetDailog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // for extract the email and send rest options links message
                        String mail = restMail.getText().toString();
                        fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(DashboardUser.this, "Password is reset to your mail", Toast.LENGTH_SHORT).show();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(DashboardUser.this, "There is problem to send rest link" +e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

                passwordResetDailog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // if user don't want to reset password

                    }
                });

                passwordResetDailog.create().show();

            }
        });



        changeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // for open gallery

                Intent openGalleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(openGalleryIntent, 1000);

                progressBar.setVisibility(View.VISIBLE); // making visible progress bar
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @androidx.annotation.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==1000){

            if (resultCode == Activity.RESULT_OK){

                Uri imageUri = data.getData();
//                profileImage.setImageURI(imageUri);


                uploadImageToFirebase(imageUri);



            }

        }

    }

    private void uploadImageToFirebase(Uri imageUri) {
        // upload image app from to firebase for user profile

        final StorageReference fileRef = storageReference.child("users/"+ fAuth.getCurrentUser().getUid()+ "/profile.jpg");  // universal profile image for individual users

//        final StorageReference fileRef = storageReference.child("profile.jpg");
        fileRef.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                Toast.makeText(DashboardUser.this, "Profile is uploaded", Toast.LENGTH_SHORT).show();
                fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Picasso.get().load(uri).into(profileImage);
                    }
                });


            }
        }).addOnFailureListener(new OnFailureListener() {

            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(DashboardUser.this, "Upload profile image is failed!", Toast.LENGTH_SHORT).show();

            }

        });
        progressBar.setVisibility(View.GONE);


    }


    // for user Logout form dashboard
    public void logout(View view) {

        FirebaseAuth.getInstance().signOut();   // after logout redirect into login page
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }


    public void tohome(View view) {
        startActivity(new Intent(getApplicationContext(), Homepage.class));
    }
}

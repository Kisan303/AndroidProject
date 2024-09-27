package com.example.travellingdestination;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class Mustang extends AppCompatActivity {

    ImageView profileImage;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mustang);

        profileImage = findViewById(R.id.profileImage);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        storageReference = FirebaseStorage.getInstance().getReference(); // for profile picture upload reference in firebase
        StorageReference profileRef = storageReference.child("users/"+fAuth.getCurrentUser().getUid()+"/profile.jpg");  // universal profile image for individual users

        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(profileImage);  // for profile images load in user profile once time save until the profile changes
            }
        });

    }

    public void profileclick(View view) {
        startActivity(new Intent(getApplicationContext(), DashboardUser.class));
    }

    public void backHomepage(View view) {
        startActivity(new Intent(getApplicationContext(), Homepage.class));
    }

    public void tomuktinath(View view) {
        startActivity(new Intent(getApplicationContext(), Muktinath.class));
    }

    public void tojomsom(View view) {
        startActivity(new Intent(getApplicationContext(), Jomsom.class));
    }

    public void tokagbeni(View view) {
        startActivity(new Intent(getApplicationContext(), Kagbeni.class));
    }

    public void tomarpha(View view) {
        startActivity(new Intent(getApplicationContext(), Marpha.class));
    }

    public void touppermustang(View view) {
        startActivity(new Intent(getApplicationContext(), UpperMustang.class));
    }
}

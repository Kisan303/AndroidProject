package com.example.travellingdestination;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class Homepage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {  // implementing Navigation clicking fragment

    private DrawerLayout drawer;

    ImageView profileImage;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);


//***************** NAVIGATION MENU TOOLBAR ID REFERENCE FROM HOMEPAGE XAML ***************************

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

//************* TO SHOWING HOME FRAGMENT ABOUT PAGE DEFAULT USER SELECTED ****************

        if (savedInstanceState ==null) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();//calling fragment sub activity page HomeFragment

         navigationView.setCheckedItem(R.id.home_nav);

        }
        
//***************************************************************************************************************

        //********** extracting profile image from dash board *************

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

//**************************************************************************************************************************

    }


//*************** Navigation implementation by clicking CRTL + I*******************

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case  R.id.home_nav:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();//calling fragment sub activity page AboutFragment
                break;

            case  R.id.about_nav:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutFragment()).commit();//calling fragment sub activity page AboutFragment
                break;

            case  R.id.contact_nav:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ContactFragment()).commit(); //calling fragment sub activity page ContactFragment
                break;

            case R.id.facebook_nav:
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/nepalandnature/")));
                break;

            case R.id.insta_nav:
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.instagram.com/travel_nepal/")));
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            super.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    //    ********** PROFILE ON CLICK TO DASHBOARD PAGE *********************************

    public void profileclick(View view) {
        startActivity(new Intent(getApplicationContext(), DashboardUser.class));
    }


//    ************* VISIT BUTTON ONLICK TO KATHMANDU PAGE***************

    public void visiteBtn(View view) {
        startActivity(new Intent(getApplicationContext(), KathmanduPage.class));
    }


// *************** pokhara page btn **********************

    public void topokhara(View view) {

        startActivity(new Intent(getApplicationContext(), Pokhara.class));
    }



// *************** Chitwan page btn **********************


    public void toChtiwan(View view) {
        startActivity(new Intent(getApplicationContext(), Chitwan.class));
    }

    public void tomustang(View view) {
        startActivity(new Intent(getApplicationContext(), Mustang.class));

    }

//***************REDIRECTING TO ROHIT GMAIL ID***************************

    public void rgmail(View view) {

        Intent intent=new Intent(Intent.ACTION_SEND);
        String[] recipients={"rohitshakya176@gmail.com"};
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT,"App Feedback");
//                intent.putExtra(Intent.EXTRA_TEXT,"Body of the content here...");
//                intent.putExtra(Intent.EXTRA_CC,"rohitshakya176@gmail.com");
        intent.setType("text/html");
        intent.setPackage("com.google.android.gm");
        startActivity(Intent.createChooser(intent, "Send mail"));

    }

    //***************REDIRECTING TO SUBASH GMAIL ID***************************

    public void sgmail(View view) {

        Intent intent=new Intent(Intent.ACTION_SEND);
        String[] recipients={"subasgurung979@gmail.com"};
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT,"App Feedback");
        intent.setType("text/html");
        intent.setPackage("com.google.android.gm");
        startActivity(Intent.createChooser(intent, "Send mail"));

    }


    //***************REDIRECTING TO KISAN GMAIL ID***************************

    public void kgmail(View view) {

        Intent intent=new Intent(Intent.ACTION_SEND);
        String[] recipients={"poold976@gmail.com"};
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT,"App Feedback");
        intent.setType("text/html");
        intent.setPackage("com.google.android.gm");
        startActivity(Intent.createChooser(intent, "Send mail"));

    }
}



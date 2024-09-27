package com.example.travellingdestination;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class RaniPokharai extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rani_pokharai);


        // third party library image slider
        ImageSlider imageSlider=findViewById(R.id.slider);

        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel( R.drawable.rhone, "Budhha statue"));
        slideModels.add(new SlideModel( R.drawable.rhtwo, "lake"));
        slideModels.add(new SlideModel( R.drawable.rhtree, "whising statue"));
        slideModels.add(new SlideModel( R.drawable.rhfour, "elephant statue"));
        slideModels.add(new SlideModel( R.drawable.rhfive, "turtle statue"));

        imageSlider.setImageList(slideModels,true);
    }

    public void ranipokharimap(View view) {

        Intent googlemp = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Rani+Pokhari/@27.6325356,84.3283617,17z/data=!3m1!4b1!4m5!3m4!1s0x3994f9dd277f08f9:0x8fa8536c1dd31212!8m2!3d27.6325356!4d84.3305504"));
        startActivity(googlemp);

    }

    public void tohome(View view) {
        startActivity(new Intent(getApplicationContext(), Homepage.class));
    }
}

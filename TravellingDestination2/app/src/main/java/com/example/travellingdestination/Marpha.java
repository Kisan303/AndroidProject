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

public class Marpha extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marpha);

        // third party library image slider
        ImageSlider imageSlider=findViewById(R.id.slider);

        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel( R.drawable.mpone, "Village"));
        slideModels.add(new SlideModel( R.drawable.mptwo, "Ghumba"));
        slideModels.add(new SlideModel( R.drawable.mpthree, "Applge tree"));
        slideModels.add(new SlideModel( R.drawable.mpfour, "Desert area"));
        slideModels.add(new SlideModel( R.drawable.mpfive, "narrow place"));

        imageSlider.setImageList(slideModels,true);
    }

    public void marphammap(View view) {
        Intent googlemp = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Marpha+33100/@28.8020493,83.5723891,12z/data=!3m1!4b1!4m5!3m4!1s0x39be093f02085989:0x6adda3e963eae707!8m2!3d28.8151445!4d83.6454831"));
        startActivity(googlemp);
    }

    public void tohome(View view) {
        startActivity(new Intent(getApplicationContext(), Homepage.class));
    }
}

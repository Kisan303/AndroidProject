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

public class BishazariTaal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bishazari_taal);

        // third party library image slider
        ImageSlider imageSlider=findViewById(R.id.slider);

        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel( R.drawable.bhfour, "Riono "));
        slideModels.add(new SlideModel( R.drawable.bhtwo, "lake"));
        slideModels.add(new SlideModel( R.drawable.bhthree, "pond lake"));
        slideModels.add(new SlideModel( R.drawable.bhfour, "lake"));


        imageSlider.setImageList(slideModels,true);
    }

    public void bishazariemap(View view) {
        Intent googlemp = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Bis+Hazari+Lake/@27.6178328,84.435374,17z/data=!3m1!4b1!4m5!3m4!1s0x3994f00264dbcedb:0x9708a223a494dc81!8m2!3d27.6178328!4d84.4375627"));
        startActivity(googlemp);
    }

    public void tohome(View view) {
        startActivity(new Intent(getApplicationContext(), Homepage.class));
    }
}


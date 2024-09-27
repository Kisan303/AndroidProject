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

public class CgTemple extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cg_temple);

        // third party library image slider
        ImageSlider imageSlider=findViewById(R.id.slider);

        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel( R.drawable.cgone, "Temple view"));
        slideModels.add(new SlideModel( R.drawable.cgtwo, "Temple view"));
        slideModels.add(new SlideModel( R.drawable.cgthree, "Temple view"));
        slideModels.add(new SlideModel( R.drawable.cgfour, "Temple view"));
        slideModels.add(new SlideModel( R.drawable.cgfive, "Temple view"));

        imageSlider.setImageList(slideModels,true);
    }

    public void cgtemplemap(View view) {
        Intent googlemp = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/CG+Temple/@27.676601,84.2091553,17z/data=!3m1!4b1!4m5!3m4!1s0x399456e8b834f2c3:0xc34097d9e826c4c0!8m2!3d27.676601!4d84.211344"));
        startActivity(googlemp);
    }

    public void tohome(View view) {
        startActivity(new Intent(getApplicationContext(), Homepage.class));
    }
}

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

public class PhewaLake extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phewa_lake);

        // third party library image slider
        ImageSlider imageSlider=findViewById(R.id.slider);

        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel( R.drawable.phone, "Mountain refection"));
        slideModels.add(new SlideModel( R.drawable.phtwo, "Boating"));
        slideModels.add(new SlideModel( R.drawable.phthree, "Samll island"));
        slideModels.add(new SlideModel( R.drawable.phfour, "Temple island"));
        slideModels.add(new SlideModel( R.drawable.phfive, "Pond"));

        imageSlider.setImageList(slideModels,true);
    }

    public void phewalakemap(View view) {
        Intent googlemap = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Phewa+Lake/@28.2116268,83.9322959,14z/data=!3m1!4b1!4m5!3m4!1s0x39959520918498bb:0xfca6adfa336fd6c7!8m2!3d28.2153837!4d83.9453168"));
        startActivity(googlemap);
    }

    public void tohome(View view) {
        startActivity(new Intent(getApplicationContext(), Homepage.class));
    }
}

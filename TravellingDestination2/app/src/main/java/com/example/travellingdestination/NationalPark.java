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

public class NationalPark extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_national_park);

        // third party library image slider
        ImageSlider imageSlider=findViewById(R.id.slider);

        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel( R.drawable.bhone, "water lake"));
        slideModels.add(new SlideModel( R.drawable.bhfour, "green pond"));
        slideModels.add(new SlideModel( R.drawable.bathree, "Street handicraft"));
        slideModels.add(new SlideModel( R.drawable.rhtwo, "place"));
        slideModels.add(new SlideModel( R.drawable.rhfive, "statue"));

        imageSlider.setImageList(slideModels,true);

    }

    public void nationalmmap(View view) {
        Intent googlemap = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/search/chitwan+national/@27.5540863,84.2778218,12z/data=!3m1!4b1"));
        startActivity(googlemap);
    }

    public void tohome(View view) {
        startActivity(new Intent(getApplicationContext(), Homepage.class));
    }
}

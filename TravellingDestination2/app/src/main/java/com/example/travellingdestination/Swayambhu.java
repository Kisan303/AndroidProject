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

public class Swayambhu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swayambhu);


        // third party library image slider
        ImageSlider imageSlider=findViewById(R.id.slider);

        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel( R.drawable.sone, "Main view"));
        slideModels.add(new SlideModel( R.drawable.stwo, "Entrance ladder"));
        slideModels.add(new SlideModel( R.drawable.sthree, "Jungle view"));
        slideModels.add(new SlideModel( R.drawable.sfour, "park"));
        slideModels.add(new SlideModel( R.drawable.sfive, "Buddha statue"));

        imageSlider.setImageList(slideModels,true);
    }


    public void swayambhumap(View view) {
        Intent googlemap = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Swayambhu,+Kathmandu+44600/@27.7201225,85.2855876,15z/data=!3m1!4b1!4m5!3m4!1s0x39eb18ece8135209:0xa82eb67cf4731fa8!8m2!3d27.7192103!4d85.2955242"));
        startActivity(googlemap);
    }

    public void tohome(View view) {
        startActivity(new Intent(getApplicationContext(), Homepage.class));
    }
}

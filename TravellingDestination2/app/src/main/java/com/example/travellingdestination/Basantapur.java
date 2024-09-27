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

public class Basantapur extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basantapur);

        // third party library image slider
        ImageSlider imageSlider=findViewById(R.id.slider);

        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel( R.drawable.baone, "Top View"));
        slideModels.add(new SlideModel( R.drawable.batwo, "Chuche mandir"));
        slideModels.add(new SlideModel( R.drawable.bathree, "Street handicraft"));
        slideModels.add(new SlideModel( R.drawable.bafour, "King palace"));
        slideModels.add(new SlideModel( R.drawable.bafive, "Kali mata"));


        imageSlider.setImageList(slideModels,true);
    }

//     Basantapur google map location link
    public void basantapurmap(View view) {
        Intent googlemap = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Basantapur,+Kathmandu+44600/@27.7043516,85.3048307,17z/data=!3m1!4b1!4m5!3m4!1s0x39eb18f8b5a16d43:0xb4f02f94e307d660!8m2!3d27.7042221!4d85.3065127"));
        startActivity(googlemap);
    }

    public void tohome(View view) {
        startActivity(new Intent(getApplicationContext(), Homepage.class));
    }
}

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

public class UpperMustang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upper_mustang);

        // third party library image slider
        ImageSlider imageSlider=findViewById(R.id.slider);

        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel( R.drawable.uone, "Desert hill"));
        slideModels.add(new SlideModel( R.drawable.utwo, "Ghumba maney"));
        slideModels.add(new SlideModel( R.drawable.uthree, "Stone maney"));
        slideModels.add(new SlideModel( R.drawable.ufour, "Desert area"));

        imageSlider.setImageList(slideModels,true);
    }

    public void uppermustangmmap(View view) {
        Intent googlemap = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Mustang/@28.9463176,83.5623963,10z/data=!3m1!4b1!4m5!3m4!1s0x39be6c7eb19f2ab7:0x2c40a8c5a03d3c04!8m2!3d28.9985065!4d83.8473015"));
        startActivity(googlemap);
    }

    public void tohome(View view) {
        startActivity( new Intent(getApplicationContext(), Homepage.class));
    }
}

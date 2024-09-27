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

public class Annapurna extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annapurna);

        // third party library image slider
        ImageSlider imageSlider=findViewById(R.id.slider);

        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel( R.drawable.aone, "Mountain View"));
        slideModels.add(new SlideModel( R.drawable.atwo, "Small Camp"));
        slideModels.add(new SlideModel( R.drawable.athree, "man and women"));
        slideModels.add(new SlideModel( R.drawable.afour, "gaurdain"));
        slideModels.add(new SlideModel( R.drawable.afive, "Doko carrying"));

        imageSlider.setImageList(slideModels,true);
    }

    public void aanapurnamap(View view) {
        Intent googlemap = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Annapurna/@28.5961103,83.8115232,15z/data=!3m1!4b1!4m5!3m4!1s0x39be1c44051f84f7:0x941cbed25f0b39fb!8m2!3d28.596111!4d83.820278"));
        startActivity(googlemap);
    }

    public void tohome(View view) {
        startActivity(new Intent(getApplicationContext(), Homepage.class));
    }
}


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

public class Jomsom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jomsom);

        // third party library image slider
        ImageSlider imageSlider=findViewById(R.id.slider);

        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel( R.drawable.jone, "Small village"));
        slideModels.add(new SlideModel( R.drawable.jtwo, "pond"));
        slideModels.add(new SlideModel( R.drawable.jthree, "Village area"));
        slideModels.add(new SlideModel( R.drawable.jfour, "Hill side"));
        slideModels.add(new SlideModel( R.drawable.jfive, "village view"));

        imageSlider.setImageList(slideModels,true);
    }

    public void jomsommap(View view) {
        Intent googlemap = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Jomsom/@28.7874716,83.7098094,12z/data=!3m1!4b1!4m5!3m4!1s0x39be0e42b3323685:0xb78689d6f4ff1019!8m2!3d28.7746477!4d83.7730237"));
        startActivity(googlemap);
    }

    public void tohome(View view) {
        startActivity(new Intent(getApplicationContext(), Homepage.class));
    }
}

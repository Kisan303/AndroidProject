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

public class Sarangkot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sarangkot);

        // third party library image slider
        ImageSlider imageSlider=findViewById(R.id.slider);

        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel( R.drawable.skone, "Paraguilding"));
        slideModels.add(new SlideModel( R.drawable.sktwo, "View Tower"));
        slideModels.add(new SlideModel( R.drawable.skthree, "house cottage"));
        slideModels.add(new SlideModel( R.drawable.skfour, "people crowd"));
        slideModels.add(new SlideModel( R.drawable.skfive, "Paraguilding"));

        imageSlider.setImageList(slideModels,true);

    }

    public void sarangkotmap(View view) {
        Intent googlemap = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Sarangkot,+Pokhara+33700/@28.2443761,83.9445644,16z/data=!3m1!4b1!4m5!3m4!1s0x399594b982657239:0x54667e1941eb00db!8m2!3d28.2439298!4d83.9486254"));
        startActivity(googlemap);
    }

    public void tohome(View view) {
        startActivity(new Intent(getApplicationContext(), Homepage.class));
    }
}

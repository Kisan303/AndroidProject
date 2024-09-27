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

public class DevidFall extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devid_fall);


        // third party library image slider
        ImageSlider imageSlider=findViewById(R.id.slider);

        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel( R.drawable.done, "Samll Shop"));
        slideModels.add(new SlideModel( R.drawable.dtwo, "waterfall"));
        slideModels.add(new SlideModel( R.drawable.dthree, "water dam"));
        slideModels.add(new SlideModel( R.drawable.dfour, "cottage"));
        slideModels.add(new SlideModel( R.drawable.dfive, "devid cave"));

        imageSlider.setImageList(slideModels,true);

    }

    public void devidfallmap(View view) {
        Intent googlemap = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Devi's+Falls,+Pokhara/@28.1901905,83.9570246,17z/data=!3m1!4b1!4m5!3m4!1s0x399595134e82378f:0xb581716c3b162f6b!8m2!3d28.1901905!4d83.9592133"));
        startActivity(googlemap);
    }

    public void tohome(View view) {
        startActivity(new Intent(getApplicationContext(), Homepage.class));
    }
}

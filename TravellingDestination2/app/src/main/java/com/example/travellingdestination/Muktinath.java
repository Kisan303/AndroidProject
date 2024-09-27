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

public class Muktinath extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muktinath);

        // third party library image slider
        ImageSlider imageSlider=findViewById(R.id.slider);

        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel( R.drawable.mone, "Dhune Dhara"));
        slideModels.add(new SlideModel( R.drawable.mtwo, "Desert area"));
        slideModels.add(new SlideModel( R.drawable.mthree, "Monastery"));
        slideModels.add(new SlideModel( R.drawable.mfour, "m=Monk temple"));
        slideModels.add(new SlideModel( R.drawable.mfive, "Desert area"));

        imageSlider.setImageList(slideModels,true);

    }

    public void muktinathmap(View view) {
        Intent googlemap = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Muktinath+33100/@28.8007877,83.7770041,12z/data=!3m1!4b1!4m5!3m4!1s0x39be13dbfa97a191:0xe585266cbba560a0!8m2!3d28.8017498!4d83.8579053"));
        startActivity(googlemap);
    }

    public void tohome(View view) {
        startActivity(new Intent(getApplicationContext(), Homepage.class));
    }
}

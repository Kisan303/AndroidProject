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

public class PasupatiPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasupati_page);


        // third party library image slider
        ImageSlider imageSlider=findViewById(R.id.slider);

        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel( R.drawable.pone, "Bhole Baba"));
        slideModels.add(new SlideModel(R.drawable.ptwo, "Top view"));
        slideModels.add(new SlideModel(R.drawable.pthree, "Human God"));
        slideModels.add(new SlideModel(R.drawable.pfour, "Night view"));
        slideModels.add(new SlideModel(R.drawable.pfive, "Hindu funeral"));
        imageSlider.setImageList(slideModels,true);
    }


//     to link pasupati map location in google map
    public void pasupatimap(View view) {

        Intent googlemap = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Pasupatinath+Temple/@27.7107005,85.3464947,17z/data=!3m1!4b1!4m5!3m4!1s0x39eb191aaaaaaaab:0x424c7d0a60df9091!8m2!3d27.7107005!4d85.3486834"));
        startActivity(googlemap);
    }

    public void tohome(View view) {
        startActivity(new Intent(getApplicationContext(), Homepage.class));
    }
}

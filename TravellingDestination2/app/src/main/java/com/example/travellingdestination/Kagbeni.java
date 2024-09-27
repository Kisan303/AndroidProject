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

public class Kagbeni extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kagbeni);


        // third party library image slider
        ImageSlider imageSlider=findViewById(R.id.slider);

        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel( R.drawable.kone, "Himal view"));
        slideModels.add(new SlideModel( R.drawable.ktwo, "Agriculture view"));
        slideModels.add(new SlideModel( R.drawable.kthree, "Hilly village"));
        slideModels.add(new SlideModel( R.drawable.kfour, "River"));
        slideModels.add(new SlideModel( R.drawable.kfive, "Agriculture view"));

        imageSlider.setImageList(slideModels,true);
    }

    public void kagbenimmap(View view) {
        Intent googlemap = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
        startActivity(googlemap);
    }

    public void tohome(View view) {
        startActivity(new Intent(getApplicationContext(),Homepage.class));
    }
}

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

public class Gandhurkh extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gandhurkh);

        // third party library image slider
        ImageSlider imageSlider=findViewById(R.id.slider);

        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel( R.drawable.gone, "Mountain view"));
        slideModels.add(new SlideModel(R.drawable.gtwo, "Hot pond"));
        slideModels.add(new SlideModel(R.drawable.gthree, "Village view"));
        slideModels.add(new SlideModel(R.drawable.gfour, "agriculture"));
        slideModels.add(new SlideModel(R.drawable.gfive, "street"));
        imageSlider.setImageList(slideModels,true);
    }

    public void ghandurkmap(View view) {
        Intent googlemap = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Ghandruk+33700/@28.4718821,83.7007037,11z/data=!3m1!4b1!4m5!3m4!1s0x3995f69b98264d51:0x48fd51cb6932d80b!8m2!3d28.4632789!4d83.8260884"));
        startActivity(googlemap);
    }

    public void tohome(View view) {
        startActivity(new Intent(getApplicationContext(), Homepage.class));
    }
}

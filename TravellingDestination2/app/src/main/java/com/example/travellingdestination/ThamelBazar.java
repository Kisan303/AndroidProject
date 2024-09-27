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

public class ThamelBazar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thamel_bazar);


        // third party library image slider
        ImageSlider imageSlider=findViewById(R.id.slider);

        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel( R.drawable.tone, "Night View"));
        slideModels.add(new SlideModel( R.drawable.ttwo, "Thamel asan"));
        slideModels.add(new SlideModel( R.drawable.tthree, "Handicraft bag"));
        slideModels.add(new SlideModel( R.drawable.tfour, "bazar"));
        slideModels.add(new SlideModel( R.drawable.tfive, "Lakhey face mask"));
        imageSlider.setImageList(slideModels,true);

    }


//     map location for thamel in google map link
    public void thamelmap(View view) {
        Intent googlemap = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Thamel,+Kathmandu+44600/@27.7150086,85.3078937,16z/data=!3m1!4b1!4m5!3m4!1s0x39eb18fcb77fd4bd:0x58099b1deffed8d4!8m2!3d27.7153902!4d85.3123293"));
        startActivity(googlemap);
    }

    public void tohome(View view) {
        startActivity(new Intent(getApplicationContext(), Homepage.class));
    }
}

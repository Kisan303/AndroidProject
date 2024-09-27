package com.example.travellingdestination;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class BoudhaPage extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boudha_page);

        viewPager = (ViewPager) findViewById(R.id.myViewPager);  // ID calling from image_Slider.xml

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
    }


//     Boudna Google Map link

    public void boudhamap(View view) {
        Intent googlemap = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Boudhha,+Kathmandu+44600/@27.7231572,85.3510666,15z/data=!3m1!4b1!4m5!3m4!1s0x39eb1bdb45cbc593:0x2d0d68684b1d03ab!8m2!3d27.7212981!4d85.3575479"));
        startActivity(googlemap);
    }

    public void tohome(View view) {
        startActivity(new Intent (getApplicationContext(), Homepage.class));

    }
}

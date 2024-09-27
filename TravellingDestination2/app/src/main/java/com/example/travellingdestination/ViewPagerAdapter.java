package com.example.travellingdestination;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerAdapter  extends PagerAdapter {  //for image slider extends

    private Context context;

    private LayoutInflater layoutInflater;

    // sorting slide images in Arrylist

    private Integer[] images ={R.drawable.skyboudha , R.drawable.bthree, R.drawable.btwo, R.drawable.bdone, R.drawable.bfade};

////     creating  Constructor

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==object ;

    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_boudha_page, null);




        ImageView imageView = (ImageView) view.findViewById(R.id.myImageView);  // ImageView ID calling from boudha_page.xml
        imageView.setImageResource(images[position]);

        ViewPager viewPager = (ViewPager)container;
        viewPager.addView(view);
        return  view;
    }

    // after slide next images remove  previous images

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager = (ViewPager)container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}

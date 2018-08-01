package com.example.sidrajawaid.automaticimageslider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class SliderViewPager extends PagerAdapter {
    private List IMAGES;
    Context context;
    private final int type;
    private LayoutInflater inflater;
    public SliderViewPager(Context context, List IMAGES, int type) {
        this.context = context;
        this.IMAGES = IMAGES;
        inflater = LayoutInflater.from(context);
        this.type = type;
    }

    @Override
    public int getCount() {
        return IMAGES.size();
    }
    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.slidingimages_layout, view, false);

        //assert imageLayout != null;
        final ImageView imageView = (ImageView) imageLayout.findViewById(R.id.image);
        imageView.setImageResource((Integer) IMAGES.get(position));
        imageLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"image clicked",Toast.LENGTH_SHORT).show();
            }
        });
        /*if (type == 7) {
            Vals.setImage(context, IMAGES.get(position), R.drawable.loading_tall, imageView);

        } else
            Vals.setImage(context, IMAGES.get(position), R.drawable.loading_slider, imageView);*/
        view.addView(imageLayout, 0);
        Configuration config = context.getResources().getConfiguration();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            if (config.getLayoutDirection() == View.LAYOUT_DIRECTION_RTL) {
                //in Right To Left layout
                imageLayout.setRotationY(180);

            }
        }
        return imageLayout;
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
    @Override
    public Parcelable saveState() {
        return null;
    }
    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

}

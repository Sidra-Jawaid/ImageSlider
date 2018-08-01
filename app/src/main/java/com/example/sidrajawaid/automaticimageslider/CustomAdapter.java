package com.example.sidrajawaid.automaticimageslider;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.design.widget.TabLayout;

import com.example.sidrajawaid.automaticimageslider.R;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    List<Object> arrayList=new ArrayList<>();
    List arrayList1;
    List<ModelClass2> arrayList2;
    Context context;
    public  final int SLIDER=0;
    public  final int NORMAL=1;
    private final RecyclerView recyclerview;
    private List topBanner;
    private List<ModelClass2> categoryTile;

    public CustomAdapter(RecyclerView view,List arrayList1,List<ModelClass2> arrayList2,Context context) {
        this.setList(arrayList1,arrayList2);
        this.arrayList1 = arrayList1;
        this.arrayList2 = arrayList2;
        this.context=context;
        this.recyclerview=view;
        setList(arrayList1,arrayList2);
    }
    public void setList(List bannerList,List<ModelClass2> normal) {
        this.topBanner = bannerList;
        this.categoryTile=normal;
        arrayList.clear();
        if (bannerList != null)
            arrayList.addAll(bannerList);
        if (normal != null)
            arrayList.addAll(normal);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        if(viewType==SLIDER)
        {
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.imagelayout,parent,false);
            return new ImageViewHolder(view);
        }
        else{
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rectanglelayout,parent,false);
            return new RectangleViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof ImageViewHolder) {
            ((ImageViewHolder) holder).viewPager.setAdapter(new SliderViewPager(context,arrayList1, getItemViewType(position)));
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    int currentPage = ((ImageViewHolder) holder).viewPager.getCurrentItem();
                    int num = ((ImageViewHolder) holder).viewPager.getAdapter().getCount();
                    if (currentPage == num - 1) {
                        currentPage = -1;
                    }
                    ((ImageViewHolder) holder).viewPager.setCurrentItem(++currentPage, true);
                    handler.postDelayed(this, 2000);
                }
            }, 2000);
            ((ImageViewHolder) holder).tabLayout.setupWithViewPager(((ImageViewHolder) holder).viewPager, true);
        }
        else if(holder instanceof RectangleViewHolder )
        {
            ((RectangleViewHolder)holder).img.setImageResource(arrayList2.get(position).getImage());
            ((RectangleViewHolder)holder).tv.setText(arrayList2.get(position).getName());
        }
    }
    @Override
    public int getItemViewType(int position) {
        if(position==3)
        {
            return SLIDER;
        }
        return NORMAL;
    }
    @Override
    public int getItemCount() {
        return arrayList.size() > 0 ? arrayList.size()-5: 1;
    }
    public class RectangleViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView tv;
        public RectangleViewHolder(View itemView) {

            super(itemView);
            img=itemView.findViewById(R.id.image1);
            tv=itemView.findViewById(R.id.tv1);
        }
    }
    public class ImageViewHolder extends RecyclerView.ViewHolder{
        public ViewPager viewPager;
        public TabLayout tabLayout;
        public ImageViewHolder(View itemView) {
            super(itemView);
            viewPager = itemView.findViewById(R.id.viewpager);
            tabLayout = itemView.findViewById(R.id.tabDots);
        }
    }
}

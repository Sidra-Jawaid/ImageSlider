package com.example.sidrajawaid.automaticimageslider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
List arrayList1;
List list;
    List arrayList2;
CustomAdapter customAdapter;
    private GridLayoutManager mGridLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
//        arrayList1=new ArrayList();
        list=new ArrayList();
        list.add(R.drawable.pic1);
        list.add(R.drawable.pic2);
        list.add(R.drawable.pic3);
        list.add(R.drawable.pic4);
        list.add(R.drawable.pic5);
        //arrayList1.add(list);
        /*arrayList1.add(R.drawable.pic1);
        arrayList1.add(R.drawable.pic2);
        arrayList1.add(R.drawable.pic3);
        arrayList1.add(R.drawable.pic4);
        arrayList1.add(R.drawable.pic5);*/

        arrayList2=new ArrayList();
        arrayList2.add((new ModelClass2(R.drawable.pic1,"user 1","tile")));
        arrayList2.add((new ModelClass2(R.drawable.pic2,"user 2","tile")));
        arrayList2.add((new ModelClass2(R.drawable.pic3,"user 3","tile")));
        arrayList2.add((new ModelClass2(R.drawable.pic4,"user 4","tile")));
        arrayList2.add((new ModelClass2(R.drawable.pic5,"user 5","tile")));
        arrayList2.add((new ModelClass2(R.drawable.pic1,"user 6","tile")));
        arrayList2.add((new ModelClass2(R.drawable.pic2,"user 7","tile")));
        arrayList2.add((new ModelClass2(R.drawable.pic3,"user 8","tile")));
        arrayList2.add((new ModelClass2(R.drawable.pic4,"user 9","tile")));
        arrayList2.add((new ModelClass2(R.drawable.pic5,"user 10","tile")));
        customAdapter=new CustomAdapter(recyclerView,list,arrayList2,getApplication());
        mGridLayoutManager = new GridLayoutManager(getApplication(), 2);
        recyclerView.setLayoutManager(mGridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(customAdapter);
        mGridLayoutManager.setInitialPrefetchItemCount(list.size() + arrayList2.size());
        recyclerView.setItemViewCacheSize(list.size() + arrayList2.size());
        ((CustomAdapter) recyclerView.getAdapter()).setList(list, arrayList2);
        mGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return customAdapter.getItemViewType(position) == ((CustomAdapter) recyclerView.getAdapter()).NORMAL ? 1 : 2;
            }
        });
    }
}

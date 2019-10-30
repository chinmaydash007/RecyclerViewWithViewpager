package com.example.recyclerviewwithviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.net.LinkAddress;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.recyclerviewwithviewpager.Adapter.MyAdpater;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
Button insert,delete;
List<String> mylist;

    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insert=findViewById(R.id.insert);
        delete=findViewById(R.id.delete);
        viewPager2 = findViewById(R.id.viewPager2);

        mylist=new ArrayList<>();

        init();

        final MyAdpater myAdpater=new MyAdpater(mylist);
        viewPager2.setAdapter(myAdpater);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        viewPager2.setPageTransformer(new Zoom());


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> insertList=new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    insertList.add(UUID.randomUUID().toString());

                }
                myAdpater.insertData(insertList);


            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> updateList=new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    updateList.add(UUID.randomUUID().toString());

                }
                myAdpater.updateData(updateList);

            }
        });
    }

    private void init() {
        for (int i = 0; i < 3; i++) {
            mylist.add(UUID.randomUUID().toString());
        }
    }
}

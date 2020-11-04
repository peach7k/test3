package com.example.test333;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView lv1;

    private int[] imagesId={R.drawable.lion,R.drawable.cat,R.drawable.dog,R.drawable.elephant,R.drawable.monkey,R.drawable.tiger};
    private	String[] names={"lion","cat","dog","elephant","monkey","tiger"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv1 = (ListView) findViewById(R.id.listView1);

        final List<Map<String,Object>> listItems = new ArrayList<Map<String,Object>>();
        for(int i=0;i<names.length;i++){
            Map<String,Object> listItem = new HashMap<String,Object>();
            listItem.put("face", imagesId[i]);
            listItem.put("name", names[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simleAdapter = new SimpleAdapter(MainActivity.this, listItems,
                R.layout.custom_list	,new String[]{"face","name"},
                new int[]{R.id.face,R.id.name});

        lv1.setAdapter(simleAdapter);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,names[position],Toast.LENGTH_SHORT).show();


            }
        });

    }
}


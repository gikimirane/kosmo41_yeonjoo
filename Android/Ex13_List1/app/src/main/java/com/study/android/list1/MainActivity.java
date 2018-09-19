package com.study.android.list1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "lecture";

    String[] names = {"문정혁","이민우","김동완","정필교","박충재","이선호"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,names);

        ListView listView1 = findViewById(R.id.listView1);

        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override //바꾸면 안되는 부분
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //바꿔서 응용할 수 있는 부분
                Toast.makeText(getApplicationContext(),
                        "selected : " + names[position],
                        Toast.LENGTH_SHORT).show();
            }
        });


    }
}

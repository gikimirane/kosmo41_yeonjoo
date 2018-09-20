package com.study.android.list4;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "lecture";

    //String[] names = {"문정혁","이민우","김동완","정필교","박충재","이선호"};
    //String[] ages = {"0216","0728","1123","1127","0819","0121"};
    //int[] images = {R.drawable.face1,R.drawable.face2,R.drawable.face3,
    //        R.drawable.face1,R.drawable.face2,R.drawable.face3 };

    MyAdapter adapter;
    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MyAdapter();

        SingerItem item1 = new SingerItem("문정혁","40",R.drawable.img1);
        adapter.addItem(item1);

        SingerItem item2 = new SingerItem("전진","39",R.drawable.img2);
        adapter.addItem(item2);

        SingerItem item3 = new SingerItem("이선호","38",R.drawable.img3);
        adapter.addItem(item3);



        ListView listView1 = (ListView) findViewById(R.id.listView1);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                SingerItem item = (SingerItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(),
                        "selected : "+ item.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
    }

    public void onBtn3Clicked(View v) {
        String inputName = editText1.getText().toString();
        String inputAge = editText2.getText().toString();

        SingerItem item = new SingerItem(inputName, inputAge, R.drawable.img1);
        adapter.addItem(item);
        adapter.notifyDataSetChanged();
    }

    class MyAdapter extends BaseAdapter {

        ArrayList<SingerItem> items = new ArrayList<>();

        public void addItem(SingerItem item) { items.add(item); }

        @Override
        public int getCount() { return items.size(); }

        @Override
        public Object getItem(int position) { return items.get(position); }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            SingerItemView view = new SingerItemView(getApplicationContext());

            SingerItem item = items.get(position);
            view.setName(item.getName());
            view.setAge(item.getAge());
            view.setImage(item.getResId());

            return view;

        }
    }
}

package com.study.android.list6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "lecture";

    //String[] names = {"문정혁","이민우","김동완","정필교","박충재","이선호"};
    //String[] ages = {"0216","0728","1123","1127","0819","0121"};
    //int[] images = {R.drawable.face1,R.drawable.face2,R.drawable.face3,
    //        R.drawable.face1,R.drawable.face2,R.drawable.face3 };

    SingerAdapter adapter;
    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new SingerAdapter(this);

        SingerItem item1 = new SingerItem("문정혁","010-1234-5678",R.drawable.img1);
        adapter.addItem(item1);

        SingerItem item2 = new SingerItem("전진","010-0324-1998",R.drawable.img2);
        adapter.addItem(item2);

        SingerItem item3 = new SingerItem("이선호","010-1981-0121",R.drawable.img3);
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

    }

//    public void onBtn1Clicked(View v) {
//        String inputName = editText1.getText().toString();
//        String inputAge = editText2.getText().toString();
//
//        SingerItem item = new SingerItem(inputName, inputAge, R.drawable.img1);
//        adapter.addItem(item);
//        adapter.notifyDataSetChanged();
//    }

}

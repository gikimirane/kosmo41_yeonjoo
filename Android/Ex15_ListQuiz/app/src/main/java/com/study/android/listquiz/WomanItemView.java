package com.study.android.listquiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WomanItemView extends LinearLayout {

    TextView textView1;
    TextView textView2;
    TextView textView3;
    ImageView imageView1;

    public WomanItemView(Context context) {
        super(context);

        LayoutInflater inflater =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        inflater.inflate(R.layout.woman_item_view, this,true);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        imageView1 = findViewById(R.id.imageView1);


    }

    public void setName(String name){
        textView1.setText(name);
    }

    public void setBirth(String Birth){
        textView2.setText(Birth);
    }

    public void setAddr(String Addr){
        textView3.setText(Addr);
    }

    public void setImage(int imgNum){
        imageView1.setImageResource(imgNum);
    }

}
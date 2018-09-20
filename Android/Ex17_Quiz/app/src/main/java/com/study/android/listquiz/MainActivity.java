package com.study.android.listquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "lecture";

    String[] names = {"정석진","윤용백","김지훈","오연주","최송이","정상준","박진수","김태형","남궁윤희","조성준","노현아","한태용","이영호","조윤희","이건후","한동인","유민상","김철언","송상운","정재엽","김현승","장희성"};
    String[] genders = {"남","남","남","여","여","남","남","남","여","남","여","남","남","여","남","남","남","남","남","남","남","남"};
    String[] births = {"1963","1984","1987","1988","1989","1990","1990","1991","1991","1992","1992","1992","1992","1992","1993","1993","1993","1993","1994","1994","1994","1995"};
    String[] addrs = {"서울시 구로구","서울시 관악구","서울시 구로구","서울시 관악구","서울시 구로구","서울시 관악구","서울시 구로구","서울시 관악구","서울시 구로구","서울시 관악구","서울시 구로구","서울시 관악구","서울시 구로구","서울시 관악구","서울시 구로구","서울시 관악구","서울시 구로구","서울시 관악구","서울시 구로구","서울시 관악구"};
    String[] phones = {"010-1212-3434","010-1212-3434","010-1212-3434","010-1212-3434","010-1212-3434","010-1212-3434","010-1212-3434","010-1212-3434","010-1212-3434","010-1212-3434","010-1212-3434","010-1212-3434","010-1212-3434","010-1212-3434","010-1212-3434","010-1212-3434","010-1212-3434","010-1212-3434","010-1212-3434","010-1212-3434","010-1212-3434"};
    int[] images = {R.drawable.woman,R.drawable.man};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MyAdapter adapter = new MyAdapter();

        ListView listView1 = findViewById(R.id.listView1);

        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Toast.makeText(getApplicationContext(),
                        "Tel : "+ phones[position],
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() { return names.length; }

        @Override
        public Object getItem(int position) {
            return names[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LinearLayout layout = new LinearLayout(getApplicationContext());
            layout.setOrientation(LinearLayout.VERTICAL);

            WomanItemView view1 = new WomanItemView(getApplicationContext());
            ManItemView view2 = new ManItemView(getApplicationContext());

            if (genders[position].equals("여")) {

                view1.setName(names[position]);
                view1.setBirth(births[position]);
                view1.setAddr(addrs[position]);
                view1.setImage(images[0]);

                layout.addView(view1);


            } else if (genders[position].equals("남")) {



                view2.setName(names[position]);
                view2.setBirth(births[position]);
                view2.setAddr(addrs[position]);
                view2.setImage(images[1]);

                layout.addView(view2);
            }

            return layout;
        }
    }
}


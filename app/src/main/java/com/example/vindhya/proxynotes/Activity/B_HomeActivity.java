package com.example.vindhya.proxynotes.Activity;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.vindhya.proxynotes.Adapter.CustomAdapter;
import com.example.vindhya.proxynotes.Fragment.C_VedioPlayer;
import com.example.vindhya.proxynotes.Model.ListItemModel;
import com.example.vindhya.proxynotes.R;

import java.util.ArrayList;

/**

 */
public class B_HomeActivity extends AppCompatActivity {

    GridView gv;
    ArrayList<ListItemModel> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_home_activity);
        gv = (GridView) findViewById(R.id.gridView1);
        createDummyData();


    }

    public void createDummyData() {

        String title = "Matter in our Surroundings - in Hindi | With Examples";
        String description = "This video explains Part 1 of cbse ncert 9 class chapter 1 in hindi. We have tried to explain this chapter, Matter in our Surroundings, with the help of real life examples and real objects for better understanding. Topics at this level are very important to understand as they form the basics of science. One cannot pursue science in higher standards if one's basics are dangling. It is important to have a solid understand of the basic concepts, hence, this video explains all the concepts in a way that one can understand it easily and remember it for the longest time possible.";

        String url = "http://proxynotes.com/assignmnet/test.mp4?videoid=";
        String duration = "0.0";

        listData = new ArrayList<>();


        listData.add(new ListItemModel(R.drawable.thumb, title, description, url + "0001", "17.32"));
        listData.add(new ListItemModel(R.drawable.thumb, title, description, url + "0002", "17.32"));
        listData.add(new ListItemModel(R.drawable.thumb, title, description, url + "0003", "17.32"));
        listData.add(new ListItemModel(R.drawable.thumb, title, description, url + "0004", "17.32"));
        gv.setAdapter(new CustomAdapter(B_HomeActivity.this, listData));

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                ListItemModel listItemModel = listData.get(i);
                C_VedioPlayer c_vedioPlayer = new C_VedioPlayer();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.ContainerId, c_vedioPlayer);
                Bundle bundle = new Bundle();
                bundle.putString("title", listItemModel.getTitle().toString());
                bundle.putString("url", listItemModel.getUrl().toString());

                c_vedioPlayer.setArguments(bundle);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });


    }


}

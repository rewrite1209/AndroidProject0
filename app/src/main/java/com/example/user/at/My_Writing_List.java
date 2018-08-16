package com.example.user.at;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

public class My_Writing_List extends AppCompatActivity {
    View view;
    ListView my_writing_post_list;
    My_Writing_list_adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_writing_post);
        my_writing_post_list=(ListView)findViewById(R.id.my_writing_post_list);
        adapter = new My_Writing_list_adapter(this,0);
        my_writing_post_list.setAdapter(adapter);
    }
}



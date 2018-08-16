package com.example.user.at;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by johan on 2018-06-05.
 */

public class My_Writing_List_Fragment extends Fragment {
    View view;
    ListView my_writing_post_list;
    My_Writing_list_adapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.my_writing_post,container,false);
        my_writing_post_list=(ListView)view.findViewById(R.id.my_writing_post_list);
        adapter = new My_Writing_list_adapter(getActivity(),0);
        my_writing_post_list.setAdapter(adapter);
        return view;
    }

}

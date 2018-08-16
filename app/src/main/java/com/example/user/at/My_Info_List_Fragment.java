package com.example.user.at;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by johan on 2018-05-24.
 */

public class My_Info_List_Fragment extends android.support.v4.app.Fragment {
    View view;
    ListView my_info_list;
    My_Info_list_adapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.my_info_main,container,false);
        my_info_list=(ListView)view.findViewById(R.id.my_info_list);
        adapter = new My_Info_list_adapter(getActivity());
        my_info_list.setAdapter(adapter);

        my_info_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MainActivity activity;
                switch(i){
                    case 0:
                        Intent intent = new Intent(getContext(),My_Writing_List.class);
                        startActivity(intent);
                        break;
                    case 1:
                        activity = (MainActivity)getActivity();
                        My_Writing_feedback_fragment My_Writing_feedback_fragment = new My_Writing_feedback_fragment();
                        activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,My_Writing_feedback_fragment).addToBackStack(null).commit();
                        break;
                    case 2:
                        activity = (MainActivity)getActivity();
                        My_Notice_Fragment My_Notice_fragment = new My_Notice_Fragment();
                        activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,My_Notice_fragment).addToBackStack(null).commit();
                        break;
                    case 3:
                        activity = (MainActivity)getActivity();
                        My_Preferences_Fragment My_Preferences_Fragment = new My_Preferences_Fragment();
                        activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,My_Preferences_Fragment).addToBackStack(null).commit();
                        break;
                }
            }
        });
        return view;
    }
}



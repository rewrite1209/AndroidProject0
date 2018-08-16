package com.example.user.at;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by johan on 2018-06-06.
 */

public class Letter_Main extends Fragment {
    View view;
    Spinner letter_spinner;
    TextView letter_text;
    int position;
    FloatingActionButton letter_floating;
    ListView letter_list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.letter_main,container,false);

        letter_spinner=(Spinner)view.findViewById(R.id.letter_spinner);
        letter_text = (TextView)view.findViewById(R.id.letter_text);
        letter_floating =(FloatingActionButton)view.findViewById(R.id.letter_floting);
        letter_list = (ListView) view.findViewById(R.id.letter_list);

        letter_floating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View dlgView = View.inflate(getActivity(),R.layout.letter_dialog,null);
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setView(dlgView);
                builder.setPositiveButton("보내기",null);
                builder.setNegativeButton("취소",null);
                builder.show();
            }
        });

        letter_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                position=i;
                switch (position) {
                    case 0:
                        letter_text.setText("받은쪽지함");
                        break;
                    case 1:
                        letter_text.setText("보낸쪽지함");
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        return view;
    }
}

package com.example.efricano.mia_2fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by e.fricano on 15/03/2017.
 */

public class Fragment_3 extends Fragment {

    Button b1=null;
    TextView tv1=null;
    static int num_volte=0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment3, container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        b1=(Button) view.findViewById(R.id.button1_fragment3);
        tv1=(TextView) view.findViewById(R.id.text1_fragment3) ;
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(num_volte==0) {
                    tv1.setText("hello");
                    num_volte++;
                } else {
                    num_volte=0;
                    tv1.setText("goodbye");

                }
            }
        });
    }
}

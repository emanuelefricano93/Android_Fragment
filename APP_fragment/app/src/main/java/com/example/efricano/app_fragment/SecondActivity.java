package com.example.efricano.app_fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container_layout, new FooFragment());
        ft.commit();
    }



    public void SecondaPagina(View v){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container_layout, new FooFragment2());
        ft.commit();
    }

    public void  SecondaPagina_SecondoFragment (View v){
        //dichiaro sempre il contenitore(FrameLayut), e la classe(che estende Fragment) da mettere su
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container_layout, new FooFragment());
        ft.commit();

    }

}

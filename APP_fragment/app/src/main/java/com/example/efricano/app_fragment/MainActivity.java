package com.example.efricano.app_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SecondaPagina(View v){
        Intent i5;
        i5 = new Intent(v.getContext(),SecondActivity.class);
        v.getContext().startActivity(i5);
    }
}

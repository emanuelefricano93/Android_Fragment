package com.example.efricano.mia_2fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements Fragment_1.OnItemSelectedListener {

    Button b=null;
    static int volte=0;
    Fragment_1 fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b=(Button) findViewById(R.id.button_1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(volte==0) {
                   //posso creare il fragment e mettergli anche delle variabili

                   FragmentTransaction transazione = getSupportFragmentManager().beginTransaction();
                   fragment=Fragment_1.newInstance("AOOOOO");
                   transazione.replace(R.id.frame_layout_1, fragment);
                   transazione.commit();
                   fragment.metodo("CIAO TI HO APPENA CREATO");
                   volte++;
               }
               else if(volte==1) {
                   FragmentTransaction transazione = getSupportFragmentManager().beginTransaction();
                   transazione.replace(R.id.frame_layout_1, new Fragment_2());
                   transazione.commit();
                   volte++;

               }

               else {
                   FragmentTransaction transazione = getSupportFragmentManager().beginTransaction();
                   transazione.replace(R.id.frame_layout_1, new Fragment_3());
                   transazione.commit();
                   volte=0;


               }
            }
        });



    }

    // Now we can define the action to take in the activity when the fragment event fires
    // This is implementing the `OnItemSelectedListener` interface methods
    @Override
    public void onRssItemSelected(String link) {
        Log.d("MyAPP","Sono nell evento su cui l activity ascolta:"+fragment.isInLayout());
        Log.d("MyAPP","Mi ha detto"+link);

    }
}

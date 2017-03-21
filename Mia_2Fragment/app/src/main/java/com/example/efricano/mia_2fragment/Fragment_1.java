package com.example.efricano.mia_2fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by e.fricano on 15/03/2017.
 */

public class Fragment_1 extends Fragment {

    Button b1=null;
    TextView tv1=null;
    static int num_volte=0;

    View view_qui=null;
    String s="";


    public static Fragment_1 newInstance(String someTitle) {
        Fragment_1 fragmentDemo = new Fragment_1();
        Bundle args = new Bundle();
        args.putString("someTitle", someTitle);
        fragmentDemo.setArguments(args);
        Log.d("MyAPP","fine new Instance");
        return fragmentDemo;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get back arguments
        String someTitle = getArguments().getString("someTitle", "");
        //this.s=someTitle;
        Log.d("MyAPP","fine onCreate:"+s);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("MyAPP","fine onCreateView:"+s);
        return inflater.inflate(R.layout.fragment1, container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {


        b1=(Button) view.findViewById(R.id.button1_fragment);
        tv1=(TextView) view.findViewById(R.id.text1_fragment) ;

        tv1.setText(s);
        Log.d("MyAPP","La s adesso è:"+ s);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(num_volte==0) {
                    tv1.setText("ciao");
                    num_volte++;
                    Log.d("MyAPP","Cliccato onSomeClick"+ s);
                    onSomeClick(v);
                } else {
                    num_volte=0;
                    tv1.setText("Arrivederci");
                }
            }
        });
        Log.d("MyAPP","fine onViewCreated");
    }
//questo metodo può essere chiamato dall Activiy per comunicare VERSO IL FRAGMENT
    public  void metodo(String s2){
        this.s=s2;
        Log.d("MyAPP","Passata Stringa dall App:"+s2);
    }

    private OnItemSelectedListener listener;

    //questo metodo invece può essere utilizzato dal fragemtn per Comunicare verso l ACTIVITY
    public interface OnItemSelectedListener {
        // This can be any number of events to be sent to the activity
        public void onRssItemSelected(String link);
    }

    // Store the listener (activity) that will have events fired once the fragment is attached
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement MyListFragment.OnItemSelectedListener");
        }
    }

    // Now we can fire the event when the user selects something in the fragment
    public void onSomeClick(View v) {
        Log.d("MyAPP","Sono nel onSomeClick");
        listener.onRssItemSelected("some link");
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings_1:
                // do whatever
                Log.d("MyAPP","Cliccato 1");
                return true;
            case R.id.action_settings_2:
                // do whatever
                Log.d("MyAPP","Cliccato 2");
                return true;
            default:
                Log.d("MyAPP","default cliccato 3");
                return super.onOptionsItemSelected(item);
        }
    }
}

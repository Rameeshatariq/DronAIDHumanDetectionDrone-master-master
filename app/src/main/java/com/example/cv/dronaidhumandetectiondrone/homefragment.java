package com.example.cv.dronaidhumandetectiondrone;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class homefragment extends Fragment {
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments

        View view=inflater.inflate(R.layout.home, container, false);
        Switch switch1 = (Switch)view.findViewById(R.id.switch1);
        Switch switch2 = (Switch)view.findViewById(R.id.switch2);
        Button location = (Button) view.findViewById(R.id.add);


        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    Intent i=new Intent(getActivity().getApplication(),RescueMode.class);
                    startActivity(i);
                    Toast.makeText(getActivity(),"Rescue Mode is On",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getActivity(),"Rescue Mode is Off",Toast.LENGTH_LONG).show();
                }
            }
        });

        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    Intent i=new Intent(getActivity(),SecurityMode.class);
                    startActivity(i);
                    Toast.makeText(getActivity(),"Security Mode is On",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getActivity(),"Security Mode is Off",Toast.LENGTH_LONG).show();

                }
            }
        });
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("DronAID");

    }}


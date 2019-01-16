package com.example.cv.dronaidhumandetectiondrone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class profile extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        FCMInstanceService fcmInstanceService=new FCMInstanceService();
        fcmInstanceService.onTokenRefresh();

        listView = findViewById(R.id.list);

        final String[] Name = {"Maham", "Nimra", "Rameesha", "Sara"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Name);
        listView.setAdapter(adapter);

    }
}

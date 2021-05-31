package com.taskfoundation.androidweardemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.taskfoundation.androidweardemo.databinding.ActivityMainBinding;

public class MainActivity extends Activity {

    private ListView listView;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        listView = binding.listView;

        if (getResources().getConfiguration().isScreenRound()) {
            Log.i("Device", "Round");
        } else {
            Log.i("Device", "Square");
        }

        String[] names = {"Hamza", "Ahmad", "Zaid", "Jafaar", "Yazeed"};

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, names);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "name is: " + names[position], Toast.LENGTH_LONG).show();
            }
        });
    }
}
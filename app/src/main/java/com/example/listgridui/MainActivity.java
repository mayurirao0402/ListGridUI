package com.example.listgridui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    String[] mobileArray = {"Android","IPhone","Windows","Blackberry","Ubuntu","Windows7"};

    GridView gridView;
    int logos[] = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Listview
        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.row_list, mobileArray);
        ListView listView = findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);

        //Gridview
        gridView = findViewById(R.id.grid_view);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), logos);
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener((parent, view, position, id) -> {
        });

        //Button & Toast
        Button button = findViewById(R.id.btn);
        button.setOnClickListener(view -> Toast.makeText(MainActivity.this, "Button clicked", Toast.LENGTH_SHORT).show());

        //Checkbox & Snackbar
        View parentLayout = findViewById(android.R.id.content);
        CheckBox checkbox = findViewById(R.id.checkbox);
        checkbox.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b){
                Snackbar.make(parentLayout, "checked", Snackbar.LENGTH_LONG).show();
            } else{
                Snackbar.make(parentLayout, "not checked", Snackbar.LENGTH_LONG).show();
            }
        });

        //SnackBar with action or customization
        Snackbar.make(parentLayout, "This is main activity", Snackbar.LENGTH_LONG)
                .setAction("Submit", view -> {
                })
                .setActionTextColor(getResources().getColor(android.R.color.holo_red_light ))
                .show();
    }
}
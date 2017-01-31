package com.example.parthmakadiya.maps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class View extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.uvpce);
        Bundle bundle = getIntent().getExtras();
        //Extract the data…
        String stuff = bundle.getString("stuff");
        TextView tvSSID = (TextView) findViewById(R.id.txtName);
       tvSSID.setText(stuff);
    }
}

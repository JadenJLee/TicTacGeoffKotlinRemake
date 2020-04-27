package com.example.dinogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GeoffFace extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geoff_face);
    }

    public void returnhome(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}

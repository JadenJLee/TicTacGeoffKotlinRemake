/*
package com.example.dinogame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraDevice;
import android.os.Bundle;
import android.telecom.VideoProfile;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    final int MY_PERMISSION_CAMERA = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, MY_PERMISSION_CAMERA);
            }
        }
        //Button startGame = findViewById(R.id.startgame);
        //Button createFace = findViewById(R.id.getface);

        //startGame.setOnClickListener(unused -> startDino());
        //createFace.setOnClickListener(unused -> setFace());
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSION_CAMERA: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //startActivity(this, GameStart.class);
                } else {
                    startActivity(new Intent(this, CantPlay.class));
                }
            }
        }
    }
    public void startDino(View view) {
        Intent intent = new Intent (this, GameStart.class);
        startActivity(intent);
    }
}
*/

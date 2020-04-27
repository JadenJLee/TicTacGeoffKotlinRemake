package com.example.dinogame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;

import java.io.IOException;
import java.util.Base64;

public class FinalFace extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_face);

        CameraPage end = new CameraPage();
        ImageView img = (ImageView) findViewById(R.id.face);
        img.setImageBitmap(end.x);
        //Drawable newImage = new BitmapDrawable(getResources(), end.);

        System.out.println("The Image has reached this point");
        /**
        Bundle data = getIntent().getExtras();
        person_object = data.getParcelable("person_object");
        // getPhoto() function returns a Base64 String
        byte[] decodedString = Base64.decode(person_object.getPhoto(), Base64.DEFAULT);

        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        img.setImageBitmap(decodedByte);
         **/

    }

}

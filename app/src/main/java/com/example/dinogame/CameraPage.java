package com.example.dinogame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class CameraPage extends AppCompatActivity {
    ImageView imageView;
    Bitmap imageBitmap;
    Bitmap x;
    private static final int CAMERA_PHOTO = 111;
    private Uri imageToUploadUri;


    static final int REQUEST_IMAGE_CAPTURE = 101;
    private Uri uriFilePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camerapage);
        //String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        //TextView textView = findViewById(R.id.asdf);

    }

    private void captureCameraImage() {
        Intent chooserIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File f = new File(Environment.getExternalStorageDirectory(), "POST_IMAGE.jpg");
        chooserIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
        imageToUploadUri = Uri.fromFile(f);
        startActivityForResult(chooserIntent, CAMERA_PHOTO);
    }

    @Override
    public void onActivityReenter(int resultCode, Intent data) {
        super.onActivityReenter(resultCode, data);
        Bitmap theMap = (Bitmap) data.getExtras().get("data");
        //imageView.setImageBitmap(theMap);
    }
    public void takePic(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            //Bitmap bmp = ImagePicker.getImageFromResult(this, resultCode, data);
            //Bitmap photo = (Bitmap) data.getExtras().get("data");
            //imageView.setImageBitmap(bmp);
            //x = bmp;
            System.out.println("this has been saved" + imageBitmap);
            //imageView.setImageBitmap(imageBitmap);
            //SaveImage(imageBitmap);
        }
        startActivity(new Intent(this, MainActivity.class));
    }

//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == CAMERA_PHOTO && resultCode == Activity.RESULT_OK) {
//            if (imageToUploadUri != null) {
//                Uri selectedImage = imageToUploadUri;
//                getContentResolver().notifyChange(imageToUploadUri, null);
//                Bitmap reducedSizeBitmap = getBitmap(selectedImage.getPath());
//                imageView = (ImageView) findViewById(R.id.face);
//                if (reducedSizeBitmap != null) {
//                    imageView.setImageBitmap(reducedSizeBitmap);
//                    imageView.setVisibility(View.VISIBLE);
//                } else {
//                    Toast.makeText(this,"Error while capturing Image",Toast.LENGTH_LONG).show();
//                }
//            } else {
//                Toast.makeText(this,"Error while capturing Image",Toast.LENGTH_LONG).show();
//            }
//        }
//    }

    public void goToGame(View view) {
        startActivity(new Intent(this, GameStart.class));
    }
//    private Bitmap getBitmap(String path) {
//
//        Uri uri = Uri.fromFile(new File(path));
//        InputStream in = null;
//        try {
//            final int IMAGE_MAX_SIZE = 1200000; // 1.2MP
//            in = getContentResolver().openInputStream(uri);
//
//            // Decode image size
//            BitmapFactory.Options o = new BitmapFactory.Options();
//            o.inJustDecodeBounds = true;
//            BitmapFactory.decodeStream(in, null, o);
//            in.close();
//
//
//            int scale = 1;
//            while ((o.outWidth * o.outHeight) * (1 / Math.pow(scale, 2)) >
//                    IMAGE_MAX_SIZE) {
//                scale++;
//            }
//            Log.d("", "scale = " + scale + ", orig-width: " + o.outWidth + ", orig-height: " + o.outHeight);
//
//            Bitmap b = null;
//            in = getContentResolver().openInputStream(uri);
//            if (scale > 1) {
//                scale--;
//                // scale to max possible inSampleSize that still yields an image
//                // larger than target
//                o = new BitmapFactory.Options();
//                o.inSampleSize = scale;
//                b = BitmapFactory.decodeStream(in, null, o);
//
//                // resize to desired dimensions
//                int height = b.getHeight();
//                int width = b.getWidth();
//                Log.d("", "1th scale operation dimenions - width: " + width + ", height: " + height);
//
//                double y = Math.sqrt(IMAGE_MAX_SIZE
//                        / (((double) width) / height));
//                double x = (y / height) * width;
//
//                Bitmap scaledBitmap = Bitmap.createScaledBitmap(b, (int) x,
//                        (int) y, true);
//                b.recycle();
//                b = scaledBitmap;
//
//                System.gc();
//            } else {
//                b = BitmapFactory.decodeStream(in);
//            }
//            in.close();
//
//            Log.d("", "bitmap size - width: " + b.getWidth() + ", height: " +
//                    b.getHeight());
//            return b;
//        } catch (IOException e) {
//            Log.e("", e.getMessage(), e);
//            return null;
//        }
//    }
}

package com.example.emotionrecognition;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class Level3HasilActivity extends AppCompatActivity {

    ImageView faceImageView;
    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3_hasil);

        faceImageView = findViewById(R.id.facialImageView);
        Bundle extras = getIntent().getExtras();
        if (extras!=null){
            Bitmap imageBitmap = (Bitmap) extras.get("imageData");
        }

        Log.d(TAG, "tes Hasil: " + extras.get("jenisEmosi"));
        Log.d(TAG, "tes Hasil: " + extras.get("imageData"));


//        faceImageView.setImageBitmap(imageBitmap); //pindah ke scene hasil
//        detectEmotion();
    }
}
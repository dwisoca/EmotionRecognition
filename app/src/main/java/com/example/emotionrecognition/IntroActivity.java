package com.example.emotionrecognition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class IntroActivity extends AppCompatActivity {

    ImageView tblPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        tblPlay = findViewById(R.id.img_play);
        tblPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntroActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
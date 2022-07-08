package com.example.emotionrecognition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Level2Activity extends AppCompatActivity {

    CardView cardContohLevel2, cardKuisLevel2;
    ImageView tblHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);

        cardContohLevel2 = findViewById(R.id.card_contoh_level2);
        cardContohLevel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Level2Activity.this, Level2ContohActivity.class);
                startActivity(intent);
            }
        });
        cardKuisLevel2 = findViewById(R.id.card_kuis_level2);
        cardKuisLevel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Level2Activity.this, Level2KuisActivity.class);
                startActivity(intent);
            }
        });
        tblHome = findViewById(R.id.img_home_contoh_level2);
        tblHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Level2Activity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
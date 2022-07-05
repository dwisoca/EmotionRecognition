package com.example.emotionrecognition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Level1Activity extends AppCompatActivity {

    CardView cardContohLevel1, cardKuisLevel1;
    ImageView tblHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        cardContohLevel1 = findViewById(R.id.card_contoh_level1);
        cardContohLevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Level1Activity.this, Level1ContohActivity.class);
                startActivity(intent);
            }
        });
        cardKuisLevel1 = findViewById(R.id.card_kuis_level1);
        cardKuisLevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Level1Activity.this, Level1ContohActivity.class);
                startActivity(intent);
            }
        });
        tblHome = findViewById(R.id.img_home_contoh_level1);
        tblHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Level1Activity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
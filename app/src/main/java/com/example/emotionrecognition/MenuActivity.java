package com.example.emotionrecognition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    CardView cardLevel1, cardLevel2, cardLevel3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        cardLevel1 = findViewById(R.id.card_level1);
        cardLevel2 = findViewById(R.id.card_level2);
        cardLevel3 = findViewById(R.id.card_level3);

        cardLevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, Level1Activity.class);
                startActivity(intent);
            }
        });
        cardLevel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, Level2Activity.class);
                startActivity(intent);
            }
        });
        cardLevel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, Level3Activity.class);
                startActivity(intent);
            }
        });
    }
}
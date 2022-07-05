package com.example.emotionrecognition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

public class Level2ContohActivity extends AppCompatActivity {

    CardView cardSenang, cardSedih, cardMarah, cardTakut;
    ImageView tblHome, tblPrevVideo, tblNextVideo;
    Uri uri;
    String emosi = "Senang";
    VideoView simpleVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2_contoh);

        // initiate a video view
        simpleVideoView = findViewById(R.id.video_level2_contoh);
        playVideo(R.raw.smile_sample);
        simpleVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                simpleVideoView.start();
            }
        });

        tblHome = findViewById(R.id.img_home_contoh_level2);
        tblHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Level2ContohActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        cardSenang = findViewById(R.id.card_senang_level2);
        cardSenang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo(R.raw.smile_sample);
                disableAllButton();
                cardSenang.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lev2_yellow));
                emosi = "Senang";
            }
        });
        cardSedih = findViewById(R.id.card_sedih_level2);
        cardSedih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo(R.raw.sad_video);
                disableAllButton();
                cardSedih.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lev2_yellow));
                emosi = "Sedih";
            }
        });
        cardMarah = findViewById(R.id.card_marah_level2);
        cardMarah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo(R.raw.smile_sample);
                disableAllButton();
                cardMarah.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lev2_yellow));
                emosi = "Marah";
            }
        });
        cardTakut = findViewById(R.id.card_takut_level2);
        cardTakut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo(R.raw.sad_video);
                disableAllButton();
                cardTakut.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lev2_yellow));
                emosi = "Takut";
            }
        });
        tblPrevVideo = findViewById(R.id.img_tbl_prev_lev2);
        tblPrevVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tblPrevVideo.setVisibility(View.GONE);
                tblNextVideo.setVisibility(View.VISIBLE);
                if(emosi.contains("Senang")){
                    playVideo(R.raw.smile_sample);
                } else if (emosi.contains("Sedih")){
                    playVideo(R.raw.sad_video);
                } else if (emosi.contains("Marah")){
                    playVideo(R.raw.smile_sample);
                } else if (emosi.contains("Takut")){
                    playVideo(R.raw.sad_video);
                }
            }
        });
        tblNextVideo = findViewById(R.id.img_tbl_next_lev2);
        tblNextVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tblNextVideo.setVisibility(View.GONE);
                tblPrevVideo.setVisibility(View.VISIBLE);
                if(emosi.contains("Senang")){
                    playVideo(R.raw.sad_video);
                } else if (emosi.contains("Sedih")){
                    playVideo(R.raw.smile_sample);
                } else if (emosi.contains("Marah")){
                    playVideo(R.raw.sad_video);
                } else if (emosi.contains("Takut")){
                    playVideo(R.raw.smile_sample);
                }
            }
        });
    }

    private void playVideo(int aset) {
        uri = Uri.parse("android.resource://" + getPackageName() + "/" + aset);
        simpleVideoView.setVideoURI(uri);
        simpleVideoView.start();
    }

    private void disableAllButton() {
        cardSenang.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lev1_grey));
        cardMarah.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lev1_grey));
        cardSedih.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lev1_grey));
        cardTakut.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lev1_grey));
    }
}
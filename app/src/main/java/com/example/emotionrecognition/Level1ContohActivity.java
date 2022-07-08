package com.example.emotionrecognition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

public class Level1ContohActivity extends AppCompatActivity {

    CardView cardSenang, cardSedih, cardMarah, cardTakut;
    ImageView tblHome, tblPrevVideo, tblNextVideo;
    Uri uri;
    String emosi = "Senang";
    VideoView simpleVideoView;
    TextView teksJudul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1_contoh);

        teksJudul = findViewById(R.id.txt_judul_contoh_level1);

        // initiate a video view
        simpleVideoView = findViewById(R.id.video_level1_contoh);
        simpleVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setVolume(0,0);
            }
        });
        playVideo(R.raw.l_senang_level1);
        simpleVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                simpleVideoView.start();
            }
        });

        tblHome = findViewById(R.id.img_home_contoh_level1);
        tblHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Level1ContohActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        cardSenang = findViewById(R.id.card_senang_level1);
        cardSenang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo(R.raw.l_senang_level1);
                disableAllButton();
                cardSenang.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lev1_green));
                emosi = "Senang";
                resetButtonNext();
                teksJudul.setText("Ekspresi Senang");
            }
        });
        cardSedih = findViewById(R.id.card_sedih_level1);
        cardSedih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo(R.raw.l_sedih_level1);
                disableAllButton();
                cardSedih.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lev1_green));
                emosi = "Sedih";
                resetButtonNext();
                teksJudul.setText("Ekspresi Sedih");
            }
        });
        cardMarah = findViewById(R.id.card_marah_level1);
        cardMarah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo(R.raw.l_marah_level1);
                disableAllButton();
                cardMarah.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lev1_green));
                emosi = "Marah";
                resetButtonNext();
                teksJudul.setText("Ekspresi Marah");
            }
        });
        cardTakut = findViewById(R.id.card_takut_level1);
        cardTakut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo(R.raw.l_takut_level1);
                disableAllButton();
                cardTakut.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lev1_green));
                emosi = "Takut";
                resetButtonNext();
                teksJudul.setText("Ekspresi Takut");
            }
        });
        tblPrevVideo = findViewById(R.id.img_tbl_prev);
        tblPrevVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tblPrevVideo.setVisibility(View.GONE);
                tblNextVideo.setVisibility(View.VISIBLE);
                if(emosi.contains("Senang")){
                    playVideo(R.raw.l_senang_level1);
                } else if (emosi.contains("Sedih")){
                    playVideo(R.raw.l_sedih_level1);
                } else if (emosi.contains("Marah")){
                    playVideo(R.raw.l_marah_level1);
                } else if (emosi.contains("Takut")){
                    playVideo(R.raw.l_takut_level1);
                }
            }
        });
        tblNextVideo = findViewById(R.id.img_tbl_next);
        tblNextVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tblNextVideo.setVisibility(View.GONE);
                tblPrevVideo.setVisibility(View.VISIBLE);
                if(emosi.contains("Senang")){
                    playVideo(R.raw.p_senang_level1);
                } else if (emosi.contains("Sedih")){
                    playVideo(R.raw.p_sedih_level1);
                } else if (emosi.contains("Marah")){
                    playVideo(R.raw.p_marah_level1);
                } else if (emosi.contains("Takut")){
                    playVideo(R.raw.p_takut_level1);
                }
            }
        });
    }

    private void resetButtonNext() {
        tblPrevVideo.setVisibility(View.GONE);
        tblNextVideo.setVisibility(View.VISIBLE);
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

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Level1Activity.class);
        startActivity(intent);
    }
}
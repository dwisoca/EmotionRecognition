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
import android.widget.TextView;
import android.widget.VideoView;

public class Level2ContohActivity extends AppCompatActivity {

    CardView cardSenang, cardSedih, cardMarah, cardTakut;
    ImageView tblHome, tblPrevVideo, tblNextVideo;
    Uri uri;
    String emosi = "Senang";
    VideoView simpleVideoView;
    TextView teksJudul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2_contoh);

        teksJudul = findViewById(R.id.txt_judul_contoh_level2);

        // initiate a video view
        simpleVideoView = findViewById(R.id.video_level2_contoh);
        playVideo(R.raw.l_senang_level2);
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
                playVideo(R.raw.l_senang_level2);
                disableAllButton();
                cardSenang.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lev2_yellow));
                emosi = "Senang";
                resetButtonNext();
                teksJudul.setText("Ekspresi Senang");
            }
        });
        cardSedih = findViewById(R.id.card_sedih_level2);
        cardSedih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo(R.raw.l_sedih_level2);
                disableAllButton();
                cardSedih.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lev2_yellow));
                emosi = "Sedih";
                resetButtonNext();
                teksJudul.setText("Ekspresi Sedih");
            }
        });
        cardMarah = findViewById(R.id.card_marah_level2);
        cardMarah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo(R.raw.l_marah_level2);
                disableAllButton();
                cardMarah.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lev2_yellow));
                emosi = "Marah";
                resetButtonNext();
                teksJudul.setText("Ekspresi Marah");
            }
        });
        cardTakut = findViewById(R.id.card_takut_level2);
        cardTakut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo(R.raw.l_takut_level2);
                disableAllButton();
                cardTakut.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lev2_yellow));
                emosi = "Takut";
                resetButtonNext();
                teksJudul.setText("Ekspresi Takut");
            }
        });
        tblPrevVideo = findViewById(R.id.img_tbl_prev_lev2);
        tblPrevVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tblPrevVideo.setVisibility(View.GONE);
                tblNextVideo.setVisibility(View.VISIBLE);
                if(emosi.contains("Senang")){
                    playVideo(R.raw.l_senang_level2);
                } else if (emosi.contains("Sedih")){
                    playVideo(R.raw.l_sedih_level2);
                } else if (emosi.contains("Marah")){
                    playVideo(R.raw.l_marah_level2);
                } else if (emosi.contains("Takut")){
                    playVideo(R.raw.l_takut_level2);
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
                    playVideo(R.raw.p_senang_level2);
                } else if (emosi.contains("Sedih")){
                    playVideo(R.raw.p_sedih_level2);
                } else if (emosi.contains("Marah")){
                    playVideo(R.raw.p_marah_level2);
                } else if (emosi.contains("Takut")){
                    playVideo(R.raw.p_takut_level2);
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
        Intent intent = new Intent(this, Level2Activity.class);
        startActivity(intent);
    }
}
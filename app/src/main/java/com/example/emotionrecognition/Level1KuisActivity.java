package com.example.emotionrecognition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

public class Level1KuisActivity extends AppCompatActivity {

    VideoView simpleVideoView;
    Uri uri;
    ImageView tblHome, imgOpsi1, imgOpsi2, imgOpsi3, imgOpsi4;
    CardView soal1, soal2, soal3, soal4, opsi1, opsi2, opsi3, opsi4;
    AlertDialog.Builder dialogBuilder;
    AlertDialog alertDialog;
    String jawaban;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1_kuis);

        // initiate a video view
        simpleVideoView = findViewById(R.id.video_level1_kuis);
        simpleVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setVolume(0,0);
            }
        });
        playVideo(R.raw.p_marah_level1);
        simpleVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                simpleVideoView.start();
            }
        });

        //Default Jawaban
        jawaban = "Marah";

        tblHome = findViewById(R.id.img_home_kuis_level1);
        tblHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Level1KuisActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        soal1 = findViewById(R.id.card_soal1_level1);
        soal2 = findViewById(R.id.card_soal2_level1);
        soal3 = findViewById(R.id.card_soal3_level1);
        soal4 = findViewById(R.id.card_soal4_level1);
        opsi1 = findViewById(R.id.card_opsi1_level1);
        opsi2 = findViewById(R.id.card_opsi2_level1);
        opsi3 = findViewById(R.id.card_opsi3_level1);
        opsi4 = findViewById(R.id.card_opsi4_level1);
        imgOpsi1 = findViewById(R.id.img_opsi1_level1);
        imgOpsi2 = findViewById(R.id.img_opsi2_level1);
        imgOpsi3 = findViewById(R.id.img_opsi3_level1);
        imgOpsi4 = findViewById(R.id.img_opsi4_level1);

        soal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disableAllButton();
                soal1.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lev1_green));
                playVideo(R.raw.p_marah_level1);
                jawaban = "Marah";
                showOpsiL();
            }
        });
        soal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disableAllButton();
                soal2.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lev1_green));
                playVideo(R.raw.l_takut_level1);
                jawaban = "Takut";
                showOpsiP();
            }
        });
        soal3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disableAllButton();
                soal3.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lev1_green));
                playVideo(R.raw.p_senang_level1);
                jawaban = "Senang";
                showOpsiL();
            }
        });
        soal4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disableAllButton();
                soal4.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lev1_green));
                playVideo(R.raw.l_sedih_level1);
                jawaban = "Sedih";
                showOpsiP();
            }
        });
        opsi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (jawaban.contains("Senang")){
                    showAlertDialog(R.layout.dialog_benar, R.raw.sfx_ok);
                } else {
                    showAlertDialog(R.layout.dialog_salah, R.raw.sfx_wrong);
                }
            }
        });
        opsi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (jawaban.contains("Sedih")){
                    showAlertDialog(R.layout.dialog_benar, R.raw.sfx_ok);
                } else {
                    showAlertDialog(R.layout.dialog_salah, R.raw.sfx_wrong);
                }
            }
        });
        opsi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (jawaban.contains("Marah")){
                    showAlertDialog(R.layout.dialog_benar, R.raw.sfx_ok);
                } else {
                    showAlertDialog(R.layout.dialog_salah, R.raw.sfx_wrong);
                }
            }
        });
        opsi4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (jawaban.contains("Takut")){
                    showAlertDialog(R.layout.dialog_benar, R.raw.sfx_ok);
                } else {
                    showAlertDialog(R.layout.dialog_salah, R.raw.sfx_wrong);
                }
            }
        });
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void showOpsiL() {
        imgOpsi1.setImageDrawable(getDrawable(R.drawable.opsi_senang_l));
        imgOpsi2.setImageDrawable(getDrawable(R.drawable.opsi_sedih_l));
        imgOpsi3.setImageDrawable(getDrawable(R.drawable.opsi_marah_l));
        imgOpsi4.setImageDrawable(getDrawable(R.drawable.opsi_takut_l));
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    private void showOpsiP() {
        imgOpsi1.setImageDrawable(getDrawable(R.drawable.opsi_senang_p));
        imgOpsi2.setImageDrawable(getDrawable(R.drawable.opsi_sedih_p));
        imgOpsi3.setImageDrawable(getDrawable(R.drawable.opsi_marah_p));
        imgOpsi4.setImageDrawable(getDrawable(R.drawable.opsi_takut_p));
    }

    private void showAlertDialog(int layout, int aset) {
        dialogBuilder = new AlertDialog.Builder(Level1KuisActivity.this);
        View view = getLayoutInflater().inflate(layout, null);
        ImageView dialogButton = view.findViewById(R.id.img_reload_dialog);

        final MediaPlayer mp = MediaPlayer.create(getApplicationContext(), aset);
        mp.start();

        dialogBuilder.setView(view);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
    }

    private void playVideo(int aset) {
        uri = Uri.parse("android.resource://" + getPackageName() + "/" + aset);
        simpleVideoView.setVideoURI(uri);
        simpleVideoView.start();
    }

    private void disableAllButton() {
        soal1.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lev1_grey));
        soal2.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lev1_grey));
        soal3.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lev1_grey));
        soal4.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lev1_grey));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Level1Activity.class);
        startActivity(intent);
    }

}
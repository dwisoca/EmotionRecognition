package com.example.emotionrecognition;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class Level1ContohActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1_contoh);

        // initiate a video view
        VideoView simpleVideoView = (VideoView) findViewById(R.id.video_level1_contoh);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.smile_sample);
        simpleVideoView.setVideoURI(uri);
        simpleVideoView.start();
        /** MEMBUAT VIDEO SQUARE (GAGAL)
//        simpleVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mediaPlayer) {
//                float videoRatio = mediaPlayer.getVideoWidth() / (float) mediaPlayer.getVideoHeight();
//                float screenRatio = simpleVideoView.getWidth() / (float)
//                        simpleVideoView.getHeight();
//                float scaleX = videoRatio / screenRatio;
//                if (scaleX >= 1f) {
//                    simpleVideoView.setScaleX(scaleX);
//                } else {
//                    simpleVideoView.setScaleY(1f / scaleX);
//                }
//            }
//        });
         **/
        simpleVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                simpleVideoView.start();
            }
        });
    }
}
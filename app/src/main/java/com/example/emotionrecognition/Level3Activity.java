package com.example.emotionrecognition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.predictivemodels.Classification;
import com.example.predictivemodels.TensorFlowClassifier;

public class Level3Activity extends AppCompatActivity {


    static final int REQUEST_IMAGE_CAPTURE = 1;
    CardView cardSenang, cardSedih, cardTakut, cardMarah;
    String emosi;
    private String TAG;
    ImageView faceImageView;
    LinearLayout layoutOpsi, layoutHasil;
    TensorFlowClassifier classifier;
    static final int PIXEL_WIDTH = 48;
    TextView textHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);

        loadModel();

        cardMarah = findViewById(R.id.card_marah);
        cardSedih = findViewById(R.id.card_sedih);
        cardTakut = findViewById(R.id.card_takut);
        cardSenang = findViewById(R.id.card_senang);

        cardSenang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
                emosi = "Senang";
            }
        });

        faceImageView = findViewById(R.id.facialImageView);
        layoutOpsi = findViewById(R.id.layout_opsi);
        layoutHasil = findViewById(R.id.layout_hasil);
        textHasil = findViewById(R.id.txt_hasil_level3);
    }

    private void detectEmotion(){

        Bitmap image=((BitmapDrawable)faceImageView.getDrawable()).getBitmap();
        Bitmap grayImage = toGrayscale(image);
        Bitmap resizedImage=getResizedBitmap(grayImage,48,48);
        int pixelarray[];

        //Initialize the intArray with the same size as the number of pixels on the image
        pixelarray = new int[resizedImage.getWidth()*resizedImage.getHeight()];

        //copy pixel data from the Bitmap into the 'intArray' array
        resizedImage.getPixels(pixelarray, 0, resizedImage.getWidth(), 0, 0, resizedImage.getWidth(), resizedImage.getHeight());


        float normalized_pixels [] = new float[pixelarray.length];
        for (int i=0; i < pixelarray.length; i++) {
            // 0 for white and 255 for black
            int pix = pixelarray[i];
            int b = pix & 0xff;
            //  normalized_pixels[i] = (float)((0xff - b)/255.0);
            // normalized_pixels[i] = (float)(b/255.0);
            normalized_pixels[i] = (float)(b);

        }
        System.out.println(normalized_pixels);
        Log.d("pixel_values",String.valueOf(normalized_pixels));
        String text=null;

        try{
            final Classification res = classifier.recognize(normalized_pixels);
            //if it can't classify, output a question mark
            if (res.getLabel() == null) {
                text = "";
            } else {
                //else output its name
                text = String.format("%s %s, %f\n", "", res.getLabel(),
                        res.getConf());
                //Membuat kondisi sesuai tombol
                if (text.contains(emosi) && res.getConf()>0.4){
                    textHasil.setText(text + "Mantap");
                } else {
                    textHasil.setText(text);
                }
            }}
        catch (Exception  e){
            System.out.print("Exception:"+e.toString());
        }
    }

    public Bitmap toGrayscale(Bitmap bmpOriginal) {
        int width, height;
        height = bmpOriginal.getHeight();
        width = bmpOriginal.getWidth();

        Bitmap bmpGrayscale = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bmpGrayscale);
        Paint paint = new Paint();
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0);
        ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
        paint.setColorFilter(f);
        c.drawBitmap(bmpOriginal, 0, 0, paint);
        return bmpGrayscale;
    }

    public Bitmap getResizedBitmap(Bitmap image, int bitmapWidth, int bitmapHeight) {
        return Bitmap.createScaledBitmap(image, bitmapWidth, bitmapHeight, true);
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            faceImageView.setImageBitmap(imageBitmap);
            detectEmotion();
            layoutHasil.setVisibility(View.VISIBLE);
            layoutOpsi.setVisibility(View.GONE);
        }
    }

    private void loadModel() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    classifier=TensorFlowClassifier.create(getAssets(), "CNN",
                            "opt_em_convnet_5000.pb", "labels.txt", PIXEL_WIDTH,
                            "input", "output_50", true, 7);

                } catch (final Exception e) {
                    //if they aren't found, throw an error!
                    throw new RuntimeException("Error initializing classifiers!", e);
                }
            }
        }).start();
    }
}
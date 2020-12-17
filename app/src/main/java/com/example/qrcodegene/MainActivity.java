package com.example.qrcodegene;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;


public class MainActivity extends AppCompatActivity {

    EditText qvalue;
    ImageView img;
    Button generateqr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        qvalue = (EditText)findViewById(R.id.qrvalue);
        img = (ImageView) findViewById(R.id.qrcode);
        generateqr = (Button)findViewById(R.id.generate);

        generateqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String input = qvalue.getText().toString();


                QRGEncoder qrgEncoder = new QRGEncoder(input,null, QRGContents.Type.TEXT,10);
                Bitmap bitmap = qrgEncoder.getBitmap();
                img.setImageBitmap(bitmap);



            }
        });
    }
}
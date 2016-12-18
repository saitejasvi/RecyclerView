package com.tejasvi7.meettheteam;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.TextView;



public class FullBio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_bio);
        ImageView imageView= (ImageView) findViewById(R.id.imageView);
        TextView textView= (TextView) findViewById(R.id.textView);
        TextView textView2= (TextView) findViewById(R.id.textView2);
        TextView textView3= (TextView) findViewById(R.id.textView3);
        TextView textView4= (TextView) findViewById(R.id.textView4);
        TextView textView5= (TextView) findViewById(R.id.textView5);
        Bundle extras = getIntent().getExtras();
        textView.setText(extras.getString("firstName"));
        textView2.setText(extras.getString("lastName"));
        textView3.setText(extras.getString("title"));
        textView4.setText(extras.getString("id"));
        textView5.setText(extras.getString("bio"));
String avatar=extras.getString("image");
        byte[] decodedString = Base64.decode(avatar, Base64.URL_SAFE);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        imageView.setImageBitmap(decodedByte);
    }
}

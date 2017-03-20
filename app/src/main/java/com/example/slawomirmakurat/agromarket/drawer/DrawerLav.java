package com.example.slawomirmakurat.agromarket.drawer;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.example.slawomirmakurat.agromarket.R;

public class DrawerLav extends Activity {

    private Bitmap bitmap;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_card);

        bitmap = ((BitmapDrawable) getDrawable(R.mipmap.ic_launcher)).getBitmap();
        imageView = (ImageView) findViewById(R.id.imageView3);

        RoundedBitmapDrawable avatar = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        avatar.setCircular(true);



//        setContentView(R.layout.activity_lav);
    }
}

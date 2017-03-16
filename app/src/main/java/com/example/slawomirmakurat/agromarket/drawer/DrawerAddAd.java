package com.example.slawomirmakurat.agromarket.drawer;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.slawomirmakurat.agromarket.R;

import java.util.List;


public class DrawerAddAd extends AppCompatActivity {

    private Post_add post_add = new Post_add();

    private ImageButton camera_imageButton;
    private Spinner spinner_category;
    private EditText titleAd_editText;
    private EditText textAd_editText;
    private Button seeAd_button;
    private Button addd_Ad_button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_add_ad);

        camera_imageButton = (ImageButton) findViewById(R.id.camera_imageButton);
        spinner_category = (Spinner) findViewById(R.id.spinner_category);
        titleAd_editText = (EditText) findViewById(R.id.titleAd_editText);
        textAd_editText = (EditText) findViewById(R.id.textAd_editText);
        seeAd_button = (Button) findViewById(R.id.seeAd_button);
        addd_Ad_button = (Button) findViewById(R.id.addd_Ad_button);

//        List<String> fragmentsList = post_add.get

    }
}

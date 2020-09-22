package com.reto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Animal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

        ImageView imageView = (ImageView) findViewById(R.id.imgAnimal);
        ImageButton sound = (ImageButton) findViewById(R.id.btnSound);
        TextView name = (TextView) findViewById(R.id.textName);
        TextView descp = (TextView) findViewById(R.id.textDesc);

        final Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null){
            imageView.setImageResource(bundle.getInt("img"));
            name.setText(bundle.getString("name"));
            descp.setText(bundle.getString("desc"));
            int positionSound = bundle.getInt("sonido");
            sound.setOnClickListener(v -> {
                MediaPlayer media = MediaPlayer.create(getApplicationContext(), positionSound);
                media.start();
            });
        }
    }
}
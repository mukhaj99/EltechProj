package com.example.max.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView imagetView;
    Button button;
    News newNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<News> listNews = new ArrayList<>();
        listNews.add(new News("test title", "test info"));

        imagetView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);
    }

    public void HobaListener(View view) {
        button.setVisibility(View.INVISIBLE);
        imagetView.setVisibility(View.VISIBLE);
    }
}

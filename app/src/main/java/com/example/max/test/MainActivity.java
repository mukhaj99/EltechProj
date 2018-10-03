package com.example.max.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
    }

    public void HobaListener(View view) {
        String day = ((TextView)view).getText().toString();
        switch(day){
            case("пн"):
                tv.setText("Список пар на понедельник");
                break;
            case("вт"):
                tv.setText("Список пар на вторник");
                break;
            case("ср"):
                tv.setText("Список пар на среду");
                break;
            case("чт"):
                tv.setText("Список пар на четверг");
                break;
            case("пт"):
                tv.setText("Список пар на пятницу");
                break;
            case("сб"):
                tv.setText("Список пар на субботу");
                break;
        }
    }
}
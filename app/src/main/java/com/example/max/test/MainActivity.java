package com.example.max.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {
    BufferedReader reader;
    Timetable[] arrTimeTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputStream is = getResources().openRawResource(R.raw.inputtimetable);
        try {
            reader = new BufferedReader(new InputStreamReader(is, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String timeTableString[] = new String[12];

        for(int i = 0; i < 12; ++i){
            try {
                timeTableString[i] = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String[] oneDay;
        String delimeter = ",";
        String[] listOfTime = timeTableString[0].split(delimeter);

        arrTimeTable = new Timetable[12];
        for(int i = 0, j = 1; i < 12 && j < timeTableString.length; ++i, ++j){
            //if(timeTableString[j] == "delim") j++;  //Check
            oneDay = timeTableString[j].split(delimeter);

            arrTimeTable[i] = new Timetable(oneDay[0]);
            for(int k = 1, countLesson = 0; k < oneDay.length; k++){
                    arrTimeTable[i].lessons[countLesson] = new Lecture(oneDay[k]+"/"+listOfTime[countLesson]);
                    countLesson++;
            }
        }
    }

    public void DayClickListener(View view) throws IOException {
        setContentView(R.layout.activity_main);
        TextView studyObjText[],teacherText[],lectureHallText[],timeText[];

        studyObjText = new TextView[6];
        studyObjText[0] = findViewById(R.id.studyObj1);
        studyObjText[1] = findViewById(R.id.studyObj2);
        studyObjText[2] = findViewById(R.id.studyObj3);
        studyObjText[3] = findViewById(R.id.studyObj4);
        studyObjText[4] = findViewById(R.id.studyObj5);
        studyObjText[5] = findViewById(R.id.studyObj6);

        teacherText = new TextView[6];
        teacherText[0] = findViewById(R.id.teacher1);
        teacherText[1] = findViewById(R.id.teacher2);
        teacherText[2] = findViewById(R.id.teacher3);
        teacherText[3] = findViewById(R.id.teacher4);
        teacherText[4] = findViewById(R.id.teacher5);
        teacherText[5] = findViewById(R.id.teacher6);

        lectureHallText = new TextView[6];
        lectureHallText[0] = findViewById(R.id.lectureHall1);
        lectureHallText[1] = findViewById(R.id.lectureHall2);
        lectureHallText[2] = findViewById(R.id.lectureHall3);
        lectureHallText[3] = findViewById(R.id.lectureHall4);
        lectureHallText[4] = findViewById(R.id.lectureHall5);
        lectureHallText[5] = findViewById(R.id.lectureHall6);

        timeText = new TextView[6];
        timeText[0] = findViewById(R.id.time1);
        timeText[1] = findViewById(R.id.time2);
        timeText[2] = findViewById(R.id.time3);
        timeText[3] = findViewById(R.id.time4);
        timeText[4] = findViewById(R.id.time5);
        timeText[5] = findViewById(R.id.time6);

        RelativeLayout relativelayout[] = new RelativeLayout[6];
        relativelayout[0] =(RelativeLayout) findViewById(R.id.relativelayout);
        relativelayout[1] =(RelativeLayout) findViewById(R.id.relativelayout2);
        relativelayout[2] =(RelativeLayout) findViewById(R.id.relativelayout3);
        relativelayout[3] =(RelativeLayout) findViewById(R.id.relativelayout4);
        relativelayout[4] =(RelativeLayout) findViewById(R.id.relativelayout5);
        relativelayout[5] =(RelativeLayout) findViewById(R.id.relativelayout6);

        String day = ((TextView)view).getText().toString();
        int numberOfDay;
        int countLesson = 0, realCountLesson = 0;
        switch(day){
            case("Пн"):
                SetDay(0,relativelayout, studyObjText, lectureHallText,teacherText,timeText);
                break;
            case("Вт"):
                SetDay(1,relativelayout, studyObjText, lectureHallText,teacherText,timeText);
                break;
            case("Ср"):
                SetDay(2,relativelayout, studyObjText, lectureHallText,teacherText,timeText);
                break;
            case("Чт"):
                SetDay(3,relativelayout, studyObjText, lectureHallText,teacherText,timeText);
                break;
            case("Пт"):
                SetDay(4,relativelayout, studyObjText, lectureHallText,teacherText,timeText);
                break;
            case("Сб"):
                SetDay(5,relativelayout, studyObjText, lectureHallText,teacherText,timeText);
                break;
        }
    }

    public void SetDay(int numberOfDay, View[] relativelayout, TextView[] studyObjText,
                       TextView[] lectureHallText, TextView[] teacherText, TextView[] timeText){
        int countLesson = 0, realCountLesson = 0;
        if(!arrTimeTable[numberOfDay].lessons[countLesson].GetLessons().equals("null")) {
            relativelayout[realCountLesson].setVisibility(View.VISIBLE);

            studyObjText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLessons());
            lectureHallText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLectureHall());
            teacherText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTeacher());
            timeText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTime());
            realCountLesson++;
        }
        countLesson++;

        if(!arrTimeTable[numberOfDay].lessons[countLesson].GetLessons().equals("null")) {
            relativelayout[realCountLesson].setVisibility(View.VISIBLE);

            studyObjText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLessons());
            lectureHallText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLectureHall());
            teacherText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTeacher());
            timeText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTime());
            realCountLesson++;
        }
        countLesson++;

        if(!arrTimeTable[numberOfDay].lessons[countLesson].GetLessons().equals("null")) {
            relativelayout[realCountLesson].setVisibility(View.VISIBLE);

            studyObjText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLessons());
            lectureHallText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLectureHall());
            teacherText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTeacher());
            timeText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTime());
            realCountLesson++;
        }
        countLesson++;

        if(!arrTimeTable[numberOfDay].lessons[countLesson].GetLessons().equals("null")) {
            relativelayout[realCountLesson].setVisibility(View.VISIBLE);

            studyObjText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLessons());
            lectureHallText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLectureHall());
            teacherText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTeacher());
            timeText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTime());
            realCountLesson++;
        }
        countLesson++;

        if(!arrTimeTable[numberOfDay].lessons[countLesson].GetLessons().equals("null")) {
            relativelayout[realCountLesson].setVisibility(View.VISIBLE);

            studyObjText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLessons());
            lectureHallText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLectureHall());
            teacherText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTeacher());
            timeText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTime());
            realCountLesson++;
        }
        countLesson++;

        if(!arrTimeTable[numberOfDay].lessons[countLesson].GetLessons().equals("null")) {
            relativelayout[realCountLesson].setVisibility(View.VISIBLE);

            studyObjText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLessons());
            lectureHallText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLectureHall());
            teacherText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTeacher());
            timeText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTime());
            realCountLesson++;
        }
    }
}
package com.example.max.test;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    BufferedReader reader;
    static Timetable[] arrTimeTable;
    static TextView studyObjText[],teacherText[],lectureHallText[],timeText[];
    static RelativeLayout relativelayout[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studyObjText = getStudyObjText();
        teacherText = getTeacherText();
        lectureHallText = getLectureHallText();
        timeText = getTimeText();
        relativelayout = getLayout();

        String Weeks[] = { "Четная неделя", "Нечетная неделя" };

        InputStream is = getResources().openRawResource(R.raw.inputtimetable);
        try {
            reader = new BufferedReader(new InputStreamReader(is, "utf-8"));
        } catch (UnsupportedEncodingException e) { e.printStackTrace(); }

        String timeTableString[] = new String[12];
        for(int i = 0; i < 12; ++i){
            try {
                timeTableString[i] = reader.readLine();
            } catch (IOException e) { e.printStackTrace(); }
        }


        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, Weeks);
        String selected = spinner.getSelectedItem().toString();
        spinner.setAdapter(adapter);

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
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        int week = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
        if(day == 1){
            //ToDo Выходной
        }else {
            if(week%2 == 0) {
                SetDay(day - 2, relativelayout, studyObjText, lectureHallText, teacherText, timeText);
            }else{
                SetDay(day - 2 + 6, relativelayout, studyObjText, lectureHallText, teacherText, timeText);
            }
        }
    }

    public void DayClickListener(View view) throws IOException {
        setContentView(R.layout.activity_main);

        relativelayout = getLayout();
        studyObjText = getStudyObjText();
        teacherText = getTeacherText();
        lectureHallText = getLectureHallText();
        timeText = getTimeText();

        Button butt;

        int week = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
        String day = ((TextView)view).getText().toString();
        switch(day){
            case("Пн"):
                butt = findViewById(R.id.button);
                butt.setPaintFlags(butt.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                if(week % 2 == 0){
                    SetDay(0,relativelayout, studyObjText, lectureHallText,teacherText,timeText);
                }else{
                    SetDay(6,relativelayout, studyObjText, lectureHallText,teacherText,timeText);
                }
                break;
            case("Вт"):
                butt = findViewById(R.id.button1);
                butt.setPaintFlags(butt.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                if(week % 2 == 0){
                    SetDay(1,relativelayout, studyObjText, lectureHallText,teacherText,timeText);
                }else{
                    SetDay(7,relativelayout, studyObjText, lectureHallText,teacherText,timeText);
                }
                break;
            case("Ср"):
                butt = findViewById(R.id.button2);
                butt.setPaintFlags(butt.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                if(week % 2 == 0){
                    SetDay(2,relativelayout, studyObjText, lectureHallText,teacherText,timeText);
                }else{
                    SetDay(8,relativelayout, studyObjText, lectureHallText,teacherText,timeText);
                }
                break;
            case("Чт"):
                butt = findViewById(R.id.button3);
                butt.setPaintFlags(butt.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                if(week % 2 == 0){
                    SetDay(3,relativelayout, studyObjText, lectureHallText,teacherText,timeText);
                }else{
                    SetDay(9,relativelayout, studyObjText, lectureHallText,teacherText,timeText);
                }
                break;
            case("Пт"):
                butt = findViewById(R.id.button4);
                butt.setPaintFlags(butt.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                if(week % 2 == 0){
                    SetDay(4,relativelayout, studyObjText, lectureHallText,teacherText,timeText);
                }else{
                    SetDay(10,relativelayout, studyObjText, lectureHallText,teacherText,timeText);
                }
                break;
            case("Сб"):
                butt = findViewById(R.id.button5);
                butt.setPaintFlags(butt.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                if(week % 2 == 0){
                    SetDay(5,relativelayout, studyObjText, lectureHallText,teacherText,timeText);
                }else{
                    SetDay(11,relativelayout, studyObjText, lectureHallText,teacherText,timeText);
                }
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
        }
    }

    RelativeLayout[] getLayout(){
        RelativeLayout out[] = new RelativeLayout[6];
        out[0] = findViewById(R.id.relativelayout);
        out[1] = findViewById(R.id.relativelayout2);
        out[2] = findViewById(R.id.relativelayout3);
        out[3] = findViewById(R.id.relativelayout4);
        out[4] = findViewById(R.id.relativelayout5);
        out[5] = findViewById(R.id.relativelayout6);
        return out;
    }

    TextView[] getTimeText(){
        TextView[] timeText = new TextView[6];
        timeText[0] = findViewById(R.id.time1);
        timeText[1] = findViewById(R.id.time2);
        timeText[2] = findViewById(R.id.time3);
        timeText[3] = findViewById(R.id.time4);
        timeText[4] = findViewById(R.id.time5);
        timeText[5] = findViewById(R.id.time6);
        return timeText;
    }

    TextView[] getLectureHallText(){
        TextView[] lectureHallText = new TextView[6];
        lectureHallText[0] = findViewById(R.id.lectureHall1);
        lectureHallText[1] = findViewById(R.id.lectureHall2);
        lectureHallText[2] = findViewById(R.id.lectureHall3);
        lectureHallText[3] = findViewById(R.id.lectureHall4);
        lectureHallText[4] = findViewById(R.id.lectureHall5);
        lectureHallText[5] = findViewById(R.id.lectureHall6);

        return lectureHallText;
    }

    TextView[] getTeacherText(){
        TextView[] teacherText = new TextView[6];
        teacherText[0] = findViewById(R.id.teacher1);
        teacherText[1] = findViewById(R.id.teacher2);
        teacherText[2] = findViewById(R.id.teacher3);
        teacherText[3] = findViewById(R.id.teacher4);
        teacherText[4] = findViewById(R.id.teacher5);
        teacherText[5] = findViewById(R.id.teacher6);
        return teacherText;
    }

    TextView[] getStudyObjText(){
        TextView[] studyObjText = new TextView[6];
        studyObjText[0] = findViewById(R.id.studyObj1);
        studyObjText[1] = findViewById(R.id.studyObj2);
        studyObjText[2] = findViewById(R.id.studyObj3);
        studyObjText[3] = findViewById(R.id.studyObj4);
        studyObjText[4] = findViewById(R.id.studyObj5);
        studyObjText[5] = findViewById(R.id.studyObj6);
        return studyObjText;
    }
}
package com.example.max.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

    TextView studyObjText,teacherText,lectureHallText,timeText;
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

        String day = ((TextView)view).getText().toString();
        switch(day){
            case("Пн"):
                studyObjText = findViewById(R.id.studyObj1);
                lectureHallText = findViewById(R.id.lectureHall1);
                teacherText = findViewById(R.id.teacher1);
                timeText = findViewById(R.id.time1);
                studyObjText.setText(arrTimeTable[0].lessons[0].GetLessons());
                lectureHallText.setText(arrTimeTable[0].lessons[0].GetLectureHall());
                teacherText.setText(arrTimeTable[0].lessons[0].GetTeacher());
                timeText.setText(arrTimeTable[0].lessons[0].GetTime());

                studyObjText = findViewById(R.id.studyObj2);
                lectureHallText = findViewById(R.id.lectureHall2);
                teacherText = findViewById(R.id.teacher2);
                timeText = findViewById(R.id.time2);
                studyObjText.setText(arrTimeTable[0].lessons[1].GetLessons());
                lectureHallText.setText(arrTimeTable[0].lessons[1].GetLectureHall());
                teacherText.setText(arrTimeTable[0].lessons[1].GetTeacher());
                timeText.setText(arrTimeTable[0].lessons[1].GetTime());

                studyObjText = findViewById(R.id.studyObj3);
                lectureHallText = findViewById(R.id.lectureHall3);
                teacherText = findViewById(R.id.teacher3);
                timeText = findViewById(R.id.time3);
                studyObjText.setText(arrTimeTable[0].lessons[2].GetLessons());
                lectureHallText.setText(arrTimeTable[0].lessons[2].GetLectureHall());
                teacherText.setText(arrTimeTable[0].lessons[2].GetTeacher());
                timeText.setText(arrTimeTable[0].lessons[2].GetTime());

                studyObjText = findViewById(R.id.studyObj4);
                lectureHallText = findViewById(R.id.lectureHall4);
                teacherText = findViewById(R.id.teacher4);
                timeText = findViewById(R.id.time4);
                studyObjText.setText(arrTimeTable[0].lessons[3].GetLessons());
                lectureHallText.setText(arrTimeTable[0].lessons[3].GetLectureHall());
                teacherText.setText(arrTimeTable[0].lessons[3].GetTeacher());
                timeText.setText(arrTimeTable[0].lessons[3].GetTime());

                studyObjText = findViewById(R.id.studyObj5);
                lectureHallText = findViewById(R.id.lectureHall5);
                teacherText = findViewById(R.id.teacher5);
                timeText = findViewById(R.id.time5);
                studyObjText.setText(arrTimeTable[0].lessons[4].GetLessons());
                lectureHallText.setText(arrTimeTable[0].lessons[4].GetLectureHall());
                teacherText.setText(arrTimeTable[0].lessons[4].GetTeacher());
                timeText.setText(arrTimeTable[0].lessons[4].GetTime());

                studyObjText = findViewById(R.id.studyObj6);
                lectureHallText = findViewById(R.id.lectureHall6);
                teacherText = findViewById(R.id.teacher6);
                timeText = findViewById(R.id.time6);
                studyObjText.setText(arrTimeTable[0].lessons[5].GetLessons());
                lectureHallText.setText(arrTimeTable[0].lessons[5].GetLectureHall());
                teacherText.setText(arrTimeTable[0].lessons[5].GetTeacher());
                timeText.setText(arrTimeTable[0].lessons[5].GetTime());
                break;
            case("Вт"):
                studyObjText = findViewById(R.id.studyObj1);
                lectureHallText = findViewById(R.id.lectureHall1);
                teacherText = findViewById(R.id.teacher1);
                timeText = findViewById(R.id.time1);
                studyObjText.setText(arrTimeTable[1].lessons[0].GetLessons());
                lectureHallText.setText(arrTimeTable[1].lessons[0].GetLectureHall());
                teacherText.setText(arrTimeTable[1].lessons[0].GetTeacher());
                timeText.setText(arrTimeTable[1].lessons[0].GetTime());

                studyObjText = findViewById(R.id.studyObj2);
                lectureHallText = findViewById(R.id.lectureHall2);
                teacherText = findViewById(R.id.teacher2);
                timeText = findViewById(R.id.time2);
                studyObjText.setText(arrTimeTable[1].lessons[1].GetLessons());
                lectureHallText.setText(arrTimeTable[1].lessons[1].GetLectureHall());
                teacherText.setText(arrTimeTable[1].lessons[1].GetTeacher());
                timeText.setText(arrTimeTable[1].lessons[1].GetTime());

                studyObjText = findViewById(R.id.studyObj3);
                lectureHallText = findViewById(R.id.lectureHall3);
                teacherText = findViewById(R.id.teacher3);
                timeText = findViewById(R.id.time3);
                studyObjText.setText(arrTimeTable[1].lessons[2].GetLessons());
                lectureHallText.setText(arrTimeTable[1].lessons[2].GetLectureHall());
                teacherText.setText(arrTimeTable[1].lessons[2].GetTeacher());
                timeText.setText(arrTimeTable[1].lessons[2].GetTime());

                studyObjText = findViewById(R.id.studyObj4);
                lectureHallText = findViewById(R.id.lectureHall4);
                teacherText = findViewById(R.id.teacher4);
                timeText = findViewById(R.id.time4);
                studyObjText.setText(arrTimeTable[1].lessons[3].GetLessons());
                lectureHallText.setText(arrTimeTable[1].lessons[3].GetLectureHall());
                teacherText.setText(arrTimeTable[1].lessons[3].GetTeacher());
                timeText.setText(arrTimeTable[1].lessons[3].GetTime());

                studyObjText = findViewById(R.id.studyObj5);
                lectureHallText = findViewById(R.id.lectureHall5);
                teacherText = findViewById(R.id.teacher5);
                timeText = findViewById(R.id.time5);
                studyObjText.setText(arrTimeTable[1].lessons[4].GetLessons());
                lectureHallText.setText(arrTimeTable[1].lessons[4].GetLectureHall());
                teacherText.setText(arrTimeTable[1].lessons[4].GetTeacher());
                timeText.setText(arrTimeTable[1].lessons[4].GetTime());

                studyObjText = findViewById(R.id.studyObj6);
                lectureHallText = findViewById(R.id.lectureHall6);
                teacherText = findViewById(R.id.teacher6);
                timeText = findViewById(R.id.time6);
                studyObjText.setText(arrTimeTable[1].lessons[5].GetLessons());
                lectureHallText.setText(arrTimeTable[1].lessons[5].GetLectureHall());
                teacherText.setText(arrTimeTable[1].lessons[5].GetTeacher());
                timeText.setText(arrTimeTable[1].lessons[5].GetTime());
                break;
            case("Ср"):
                studyObjText = findViewById(R.id.studyObj1);
                lectureHallText = findViewById(R.id.lectureHall1);
                teacherText = findViewById(R.id.teacher1);
                timeText = findViewById(R.id.time1);
                studyObjText.setText(arrTimeTable[2].lessons[0].GetLessons());
                lectureHallText.setText(arrTimeTable[2].lessons[0].GetLectureHall());
                teacherText.setText(arrTimeTable[2].lessons[0].GetTeacher());
                timeText.setText(arrTimeTable[2].lessons[0].GetTime());

                studyObjText = findViewById(R.id.studyObj2);
                lectureHallText = findViewById(R.id.lectureHall2);
                teacherText = findViewById(R.id.teacher2);
                timeText = findViewById(R.id.time2);
                studyObjText.setText(arrTimeTable[2].lessons[1].GetLessons());
                lectureHallText.setText(arrTimeTable[2].lessons[1].GetLectureHall());
                teacherText.setText(arrTimeTable[2].lessons[1].GetTeacher());
                timeText.setText(arrTimeTable[2].lessons[1].GetTime());

                studyObjText = findViewById(R.id.studyObj3);
                lectureHallText = findViewById(R.id.lectureHall3);
                teacherText = findViewById(R.id.teacher3);
                timeText = findViewById(R.id.time3);
                studyObjText.setText(arrTimeTable[2].lessons[2].GetLessons());
                lectureHallText.setText(arrTimeTable[2].lessons[2].GetLectureHall());
                teacherText.setText(arrTimeTable[2].lessons[2].GetTeacher());
                timeText.setText(arrTimeTable[2].lessons[2].GetTime());

                studyObjText = findViewById(R.id.studyObj4);
                lectureHallText = findViewById(R.id.lectureHall4);
                teacherText = findViewById(R.id.teacher4);
                timeText = findViewById(R.id.time4);
                studyObjText.setText(arrTimeTable[2].lessons[3].GetLessons());
                lectureHallText.setText(arrTimeTable[2].lessons[3].GetLectureHall());
                teacherText.setText(arrTimeTable[2].lessons[3].GetTeacher());
                timeText.setText(arrTimeTable[2].lessons[3].GetTime());

                studyObjText = findViewById(R.id.studyObj5);
                lectureHallText = findViewById(R.id.lectureHall5);
                teacherText = findViewById(R.id.teacher5);
                timeText = findViewById(R.id.time5);
                studyObjText.setText(arrTimeTable[2].lessons[4].GetLessons());
                lectureHallText.setText(arrTimeTable[2].lessons[4].GetLectureHall());
                teacherText.setText(arrTimeTable[2].lessons[4].GetTeacher());
                timeText.setText(arrTimeTable[2].lessons[4].GetTime());

                studyObjText = findViewById(R.id.studyObj6);
                lectureHallText = findViewById(R.id.lectureHall6);
                teacherText = findViewById(R.id.teacher6);
                timeText = findViewById(R.id.time6);
                studyObjText.setText(arrTimeTable[2].lessons[5].GetLessons());
                lectureHallText.setText(arrTimeTable[2].lessons[5].GetLectureHall());
                teacherText.setText(arrTimeTable[2].lessons[5].GetTeacher());
                timeText.setText(arrTimeTable[2].lessons[5].GetTime());
                break;
            case("Чт"):
                studyObjText = findViewById(R.id.studyObj1);
                lectureHallText = findViewById(R.id.lectureHall1);
                teacherText = findViewById(R.id.teacher1);
                timeText = findViewById(R.id.time1);
                studyObjText.setText(arrTimeTable[3].lessons[0].GetLessons());
                lectureHallText.setText(arrTimeTable[3].lessons[0].GetLectureHall());
                teacherText.setText(arrTimeTable[3].lessons[0].GetTeacher());
                timeText.setText(arrTimeTable[3].lessons[0].GetTime());

                studyObjText = findViewById(R.id.studyObj2);
                lectureHallText = findViewById(R.id.lectureHall2);
                teacherText = findViewById(R.id.teacher2);
                timeText = findViewById(R.id.time2);
                studyObjText.setText(arrTimeTable[3].lessons[1].GetLessons());
                lectureHallText.setText(arrTimeTable[3].lessons[1].GetLectureHall());
                teacherText.setText(arrTimeTable[3].lessons[1].GetTeacher());
                timeText.setText(arrTimeTable[3].lessons[1].GetTime());

                studyObjText = findViewById(R.id.studyObj3);
                lectureHallText = findViewById(R.id.lectureHall3);
                teacherText = findViewById(R.id.teacher3);
                timeText = findViewById(R.id.time3);
                studyObjText.setText(arrTimeTable[3].lessons[2].GetLessons());
                lectureHallText.setText(arrTimeTable[3].lessons[2].GetLectureHall());
                teacherText.setText(arrTimeTable[3].lessons[2].GetTeacher());
                timeText.setText(arrTimeTable[3].lessons[2].GetTime());

                studyObjText = findViewById(R.id.studyObj4);
                lectureHallText = findViewById(R.id.lectureHall4);
                teacherText = findViewById(R.id.teacher4);
                timeText = findViewById(R.id.time4);
                studyObjText.setText(arrTimeTable[3].lessons[3].GetLessons());
                lectureHallText.setText(arrTimeTable[3].lessons[3].GetLectureHall());
                teacherText.setText(arrTimeTable[3].lessons[3].GetTeacher());
                timeText.setText(arrTimeTable[3].lessons[3].GetTime());

                studyObjText = findViewById(R.id.studyObj5);
                lectureHallText = findViewById(R.id.lectureHall5);
                teacherText = findViewById(R.id.teacher5);
                timeText = findViewById(R.id.time5);
                studyObjText.setText(arrTimeTable[3].lessons[4].GetLessons());
                lectureHallText.setText(arrTimeTable[3].lessons[4].GetLectureHall());
                teacherText.setText(arrTimeTable[3].lessons[4].GetTeacher());
                timeText.setText(arrTimeTable[3].lessons[4].GetTime());

                studyObjText = findViewById(R.id.studyObj6);
                lectureHallText = findViewById(R.id.lectureHall6);
                teacherText = findViewById(R.id.teacher6);
                timeText = findViewById(R.id.time6);
                studyObjText.setText(arrTimeTable[3].lessons[5].GetLessons());
                lectureHallText.setText(arrTimeTable[3].lessons[5].GetLectureHall());
                teacherText.setText(arrTimeTable[3].lessons[5].GetTeacher());
                timeText.setText(arrTimeTable[3].lessons[5].GetTime());
                break;
            case("Пт"):
                studyObjText = findViewById(R.id.studyObj1);
                lectureHallText = findViewById(R.id.lectureHall1);
                teacherText = findViewById(R.id.teacher1);
                timeText = findViewById(R.id.time1);
                studyObjText.setText(arrTimeTable[4].lessons[0].GetLessons());
                lectureHallText.setText(arrTimeTable[4].lessons[0].GetLectureHall());
                teacherText.setText(arrTimeTable[4].lessons[0].GetTeacher());
                timeText.setText(arrTimeTable[4].lessons[0].GetTime());

                studyObjText = findViewById(R.id.studyObj2);
                lectureHallText = findViewById(R.id.lectureHall2);
                teacherText = findViewById(R.id.teacher2);
                timeText = findViewById(R.id.time2);
                studyObjText.setText(arrTimeTable[4].lessons[1].GetLessons());
                lectureHallText.setText(arrTimeTable[4].lessons[1].GetLectureHall());
                teacherText.setText(arrTimeTable[4].lessons[1].GetTeacher());
                timeText.setText(arrTimeTable[4].lessons[1].GetTime());

                studyObjText = findViewById(R.id.studyObj3);
                lectureHallText = findViewById(R.id.lectureHall3);
                teacherText = findViewById(R.id.teacher3);
                timeText = findViewById(R.id.time3);
                studyObjText.setText(arrTimeTable[4].lessons[2].GetLessons());
                lectureHallText.setText(arrTimeTable[4].lessons[2].GetLectureHall());
                teacherText.setText(arrTimeTable[4].lessons[2].GetTeacher());
                timeText.setText(arrTimeTable[4].lessons[2].GetTime());

                studyObjText = findViewById(R.id.studyObj4);
                lectureHallText = findViewById(R.id.lectureHall4);
                teacherText = findViewById(R.id.teacher4);
                timeText = findViewById(R.id.time4);
                studyObjText.setText(arrTimeTable[4].lessons[3].GetLessons());
                lectureHallText.setText(arrTimeTable[4].lessons[3].GetLectureHall());
                teacherText.setText(arrTimeTable[4].lessons[3].GetTeacher());
                timeText.setText(arrTimeTable[4].lessons[3].GetTime());

                studyObjText = findViewById(R.id.studyObj5);
                lectureHallText = findViewById(R.id.lectureHall5);
                teacherText = findViewById(R.id.teacher5);
                timeText = findViewById(R.id.time5);
                studyObjText.setText(arrTimeTable[4].lessons[4].GetLessons());
                lectureHallText.setText(arrTimeTable[4].lessons[4].GetLectureHall());
                teacherText.setText(arrTimeTable[4].lessons[4].GetTeacher());
                timeText.setText(arrTimeTable[4].lessons[4].GetTime());

                studyObjText = findViewById(R.id.studyObj6);
                lectureHallText = findViewById(R.id.lectureHall6);
                teacherText = findViewById(R.id.teacher6);
                timeText = findViewById(R.id.time6);
                studyObjText.setText(arrTimeTable[4].lessons[5].GetLessons());
                lectureHallText.setText(arrTimeTable[4].lessons[5].GetLectureHall());
                teacherText.setText(arrTimeTable[4].lessons[5].GetTeacher());
                timeText.setText(arrTimeTable[4].lessons[5].GetTime());
                break;
            case("Сб"):
                studyObjText = findViewById(R.id.studyObj1);
                lectureHallText = findViewById(R.id.lectureHall1);
                teacherText = findViewById(R.id.teacher1);
                timeText = findViewById(R.id.time1);
                studyObjText.setText(arrTimeTable[6].lessons[0].GetLessons());
                lectureHallText.setText(arrTimeTable[6].lessons[0].GetLectureHall());
                teacherText.setText(arrTimeTable[6].lessons[0].GetTeacher());
                timeText.setText(arrTimeTable[6].lessons[0].GetTime());

                studyObjText = findViewById(R.id.studyObj2);
                lectureHallText = findViewById(R.id.lectureHall2);
                teacherText = findViewById(R.id.teacher2);
                timeText = findViewById(R.id.time2);
                studyObjText.setText(arrTimeTable[6].lessons[1].GetLessons());
                lectureHallText.setText(arrTimeTable[6].lessons[1].GetLectureHall());
                teacherText.setText(arrTimeTable[6].lessons[1].GetTeacher());
                timeText.setText(arrTimeTable[6].lessons[1].GetTime());

                studyObjText = findViewById(R.id.studyObj3);
                lectureHallText = findViewById(R.id.lectureHall3);
                teacherText = findViewById(R.id.teacher3);
                timeText = findViewById(R.id.time3);
                studyObjText.setText(arrTimeTable[6].lessons[2].GetLessons());
                lectureHallText.setText(arrTimeTable[6].lessons[2].GetLectureHall());
                teacherText.setText(arrTimeTable[6].lessons[2].GetTeacher());
                timeText.setText(arrTimeTable[6].lessons[2].GetTime());

                studyObjText = findViewById(R.id.studyObj4);
                lectureHallText = findViewById(R.id.lectureHall4);
                teacherText = findViewById(R.id.teacher4);
                timeText = findViewById(R.id.time4);
                studyObjText.setText(arrTimeTable[6].lessons[3].GetLessons());
                lectureHallText.setText(arrTimeTable[6].lessons[3].GetLectureHall());
                teacherText.setText(arrTimeTable[6].lessons[3].GetTeacher());
                timeText.setText(arrTimeTable[6].lessons[3].GetTime());

                studyObjText = findViewById(R.id.studyObj5);
                lectureHallText = findViewById(R.id.lectureHall5);
                teacherText = findViewById(R.id.teacher5);
                timeText = findViewById(R.id.time5);
                studyObjText.setText(arrTimeTable[6].lessons[4].GetLessons());
                lectureHallText.setText(arrTimeTable[6].lessons[4].GetLectureHall());
                teacherText.setText(arrTimeTable[6].lessons[4].GetTeacher());
                timeText.setText(arrTimeTable[6].lessons[4].GetTime());

                studyObjText = findViewById(R.id.studyObj6);
                lectureHallText = findViewById(R.id.lectureHall6);
                teacherText = findViewById(R.id.teacher6);
                timeText = findViewById(R.id.time6);
                studyObjText.setText(arrTimeTable[6].lessons[5].GetLessons());
                lectureHallText.setText(arrTimeTable[6].lessons[5].GetLectureHall());
                teacherText.setText(arrTimeTable[6].lessons[5].GetTeacher());
                timeText.setText(arrTimeTable[6].lessons[5].GetTime());
                break;
        }
    }
}
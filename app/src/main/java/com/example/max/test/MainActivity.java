package com.example.max.test;


import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    int currentDay = -1;    //Flag for onItemSelectedListener and global var for current day in TimeTable
    BufferedReader reader;
    Timetable[] arrTimeTable;
    TextView studyObjText[], teacherText[], lectureHallText[], timeText[];
    RelativeLayout relativelayout[];
    Spinner spinner;
    ImageView inProcessArr[];
    String Weeks[] = {"Четная неделя", "Нечетная неделя"};
    Button dayButton[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar calendar = Calendar.getInstance();

        inProcessArr = getImageView();
        studyObjText = getStudyObjText();
        teacherText = getTeacherText();
        lectureHallText = getLectureHallText();
        timeText = getTimeText();
        relativelayout = getLayout();
        dayButton = getDayButt();

        //SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        InputStream is = getResources().openRawResource(R.raw.inputtimetable);
        try {
            reader = new BufferedReader(new InputStreamReader(is, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String timeTableString[] = new String[13];
        for (int i = 0; i < 13; ++i) {
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
        for (int i = 0, j = 1; i < 12 && j < timeTableString.length; ++i, ++j) {
            //if(timeTableString[j] == "delim") j++;  //Check
            oneDay = timeTableString[j].split(delimeter);

            arrTimeTable[i] = new Timetable(oneDay[0]);
            for (int k = 1, countLesson = 0; k < oneDay.length; k++) {
                arrTimeTable[i].lessons[countLesson] = new Lecture(oneDay[k] + "/" + listOfTime[countLesson]);
                countLesson++;
            }
        }

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item, Weeks);
        spinner.setAdapter(adapter);
        spinner.setSelection(calendar.get(Calendar.WEEK_OF_YEAR)%2);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(currentDay != -1){
                    dayButton[currentDay].performClick();
                    //SetDay(currentDay, relativelayout, studyObjText, lectureHallText, teacherText, timeText);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        String selected = spinner.getSelectedItem().toString();

        boolean isParity;
        isParity = selected.equals("Четная неделя");

        currentDay = calendar.get(Calendar.DAY_OF_WEEK);
        if (currentDay == 1) {
            //ToDo Выходной
        } else {
            dayButton[currentDay-2].performClick();
        }
    }

    public void DayClickListener(View view) throws IOException {

        relativelayout = getLayout();
        studyObjText = getStudyObjText();
        teacherText = getTeacherText();
        lectureHallText = getLectureHallText();
        timeText = getTimeText();
        dayButton = getDayButt();

        boolean isParity = (spinner.getSelectedItem().toString().equals("Четная неделя"));

        String day = ((TextView) view).getText().toString();
        switch (day) {
            case ("Пн"):
                currentDay = 0;
                dayButton[currentDay].setPaintFlags(dayButton[currentDay].getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                if (isParity) {
                    SetDay(currentDay, relativelayout, studyObjText, lectureHallText, teacherText, timeText);
                } else {
                    SetDay(currentDay + 6, relativelayout, studyObjText, lectureHallText, teacherText, timeText);
                }
                break;
            case ("Вт"):
                currentDay = 1;
                dayButton[currentDay].setPaintFlags(dayButton[currentDay].getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                if (isParity) {
                    SetDay(currentDay, relativelayout, studyObjText, lectureHallText, teacherText, timeText);
                } else {
                    SetDay(currentDay + 6, relativelayout, studyObjText, lectureHallText, teacherText, timeText);
                }
                break;
            case ("Ср"):
                currentDay = 2;
                dayButton[currentDay].setPaintFlags(dayButton[currentDay].getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                if (isParity) {
                    SetDay(currentDay, relativelayout, studyObjText, lectureHallText, teacherText, timeText);
                } else {
                    SetDay(currentDay + 6, relativelayout, studyObjText, lectureHallText, teacherText, timeText);
                }
                break;
            case ("Чт"):
                currentDay = 3;
                dayButton[currentDay].setPaintFlags(dayButton[currentDay].getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                if (isParity) {
                    SetDay(currentDay, relativelayout, studyObjText, lectureHallText, teacherText, timeText);
                } else {
                    SetDay(currentDay + 6, relativelayout, studyObjText, lectureHallText, teacherText, timeText);
                }
                break;
            case ("Пт"):
                currentDay = 4;
                dayButton[currentDay].setPaintFlags(dayButton[currentDay].getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                if (isParity) {
                    SetDay(currentDay, relativelayout, studyObjText, lectureHallText, teacherText, timeText);
                } else {
                    SetDay(currentDay + 6, relativelayout, studyObjText, lectureHallText, teacherText, timeText);
                }
                break;
            case ("Сб"):
                currentDay = 5;
                dayButton[currentDay].setPaintFlags(dayButton[currentDay].getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                if (isParity) {
                    SetDay(currentDay, relativelayout, studyObjText, lectureHallText, teacherText, timeText);
                } else {
                    SetDay(currentDay + 6, relativelayout, studyObjText, lectureHallText, teacherText, timeText);
                }
                break;
        }
    }

    public void SetDay(int numberOfDay, View[] relativelayout, TextView[] studyObjText,
                       TextView[] lectureHallText, TextView[] teacherText, TextView[] timeText) {
        int countLesson = 0, realCountLesson = 0;
        if (!arrTimeTable[numberOfDay].lessons[countLesson].GetLessons().equals("null")) {
            relativelayout[realCountLesson].setVisibility(View.VISIBLE);

            studyObjText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLessons());
            lectureHallText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLectureHall());
            teacherText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTeacher());
            timeText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTime());
            realCountLesson++;
        }
        countLesson++;

        if (!arrTimeTable[numberOfDay].lessons[countLesson].GetLessons().equals("null")) {
            relativelayout[realCountLesson].setVisibility(View.VISIBLE);

            studyObjText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLessons());
            lectureHallText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLectureHall());
            teacherText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTeacher());
            timeText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTime());
            realCountLesson++;
        }
        countLesson++;

        if (!arrTimeTable[numberOfDay].lessons[countLesson].GetLessons().equals("null")) {
            relativelayout[realCountLesson].setVisibility(View.VISIBLE);

            studyObjText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLessons());
            lectureHallText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLectureHall());
            teacherText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTeacher());
            timeText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTime());
            realCountLesson++;
        }
        countLesson++;

        if (!arrTimeTable[numberOfDay].lessons[countLesson].GetLessons().equals("null")) {
            relativelayout[realCountLesson].setVisibility(View.VISIBLE);

            studyObjText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLessons());
            lectureHallText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLectureHall());
            teacherText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTeacher());
            timeText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTime());
            realCountLesson++;
        }
        countLesson++;

        if (!arrTimeTable[numberOfDay].lessons[countLesson].GetLessons().equals("null")) {
            relativelayout[realCountLesson].setVisibility(View.VISIBLE);

            studyObjText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLessons());
            lectureHallText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLectureHall());
            teacherText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTeacher());
            timeText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTime());
            realCountLesson++;
        }
        countLesson++;

        if (!arrTimeTable[numberOfDay].lessons[countLesson].GetLessons().equals("null")) {
            relativelayout[realCountLesson].setVisibility(View.VISIBLE);

            studyObjText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLessons());
            lectureHallText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLectureHall());
            teacherText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTeacher());
            timeText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTime());
        }
    }

    RelativeLayout[] getLayout() {
        RelativeLayout out[] = new RelativeLayout[6];
        out[0] = findViewById(R.id.relativelayout);
        out[0].setVisibility(View.INVISIBLE);
        out[1] = findViewById(R.id.relativelayout2);
        out[1].setVisibility(View.INVISIBLE);
        out[2] = findViewById(R.id.relativelayout3);
        out[2].setVisibility(View.INVISIBLE);
        out[3] = findViewById(R.id.relativelayout4);
        out[3].setVisibility(View.INVISIBLE);
        out[4] = findViewById(R.id.relativelayout5);
        out[4].setVisibility(View.INVISIBLE);
        out[5] = findViewById(R.id.relativelayout6);
        out[5].setVisibility(View.INVISIBLE);
        return out;
    }

    Button[] getDayButt(){
        Button butt[] = new Button[6];
        butt[0] = findViewById(R.id.button);
        butt[0].setPaintFlags(butt[0].getPaintFlags() & (~ Paint.UNDERLINE_TEXT_FLAG));
        butt[1] = findViewById(R.id.button1);
        butt[1].setPaintFlags(butt[1].getPaintFlags() & (~ Paint.UNDERLINE_TEXT_FLAG));
        butt[2] = findViewById(R.id.button2);
        butt[2].setPaintFlags(butt[2].getPaintFlags() & (~ Paint.UNDERLINE_TEXT_FLAG));
        butt[3] = findViewById(R.id.button3);
        butt[3].setPaintFlags(butt[3].getPaintFlags() & (~ Paint.UNDERLINE_TEXT_FLAG));
        butt[4] = findViewById(R.id.button4);
        butt[4].setPaintFlags(butt[4].getPaintFlags() & (~ Paint.UNDERLINE_TEXT_FLAG));
        butt[5] = findViewById(R.id.button5);
        butt[5].setPaintFlags(butt[5].getPaintFlags() & (~ Paint.UNDERLINE_TEXT_FLAG));
        return butt;
    }

    ImageView[] getImageView(){
        ImageView inProcess[] = new ImageView[6];
        inProcess[0] = findViewById(R.id.imageView);
        inProcess[1] = findViewById(R.id.imageView2);
        inProcess[2] = findViewById(R.id.imageView3);
        inProcess[3] = findViewById(R.id.imageView4);
        inProcess[4] = findViewById(R.id.imageView5);
        inProcess[5] = findViewById(R.id.imageView6);
        return inProcess;
    }

    TextView[] getTimeText() {
        TextView[] timeText = new TextView[6];
        timeText[0] = findViewById(R.id.time1);
        timeText[1] = findViewById(R.id.time2);
        timeText[2] = findViewById(R.id.time3);
        timeText[3] = findViewById(R.id.time4);
        timeText[4] = findViewById(R.id.time5);
        timeText[5] = findViewById(R.id.time6);
        return timeText;
    }

    TextView[] getLectureHallText() {
        TextView[] lectureHallText = new TextView[6];
        lectureHallText[0] = findViewById(R.id.lectureHall1);
        lectureHallText[1] = findViewById(R.id.lectureHall2);
        lectureHallText[2] = findViewById(R.id.lectureHall3);
        lectureHallText[3] = findViewById(R.id.lectureHall4);
        lectureHallText[4] = findViewById(R.id.lectureHall5);
        lectureHallText[5] = findViewById(R.id.lectureHall6);

        return lectureHallText;
    }

    TextView[] getTeacherText() {
        TextView[] teacherText = new TextView[6];
        teacherText[0] = findViewById(R.id.teacher1);
        teacherText[1] = findViewById(R.id.teacher2);
        teacherText[2] = findViewById(R.id.teacher3);
        teacherText[3] = findViewById(R.id.teacher4);
        teacherText[4] = findViewById(R.id.teacher5);
        teacherText[5] = findViewById(R.id.teacher6);
        return teacherText;
    }

    TextView[] getStudyObjText() {
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
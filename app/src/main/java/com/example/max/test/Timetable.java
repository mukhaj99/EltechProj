package com.example.max.test;

class Lecture{
    private String subjOfStudy;
    private String teacher;
    private String lectureHall;
    public String type;
    public String timeOfLesson;

    Lecture(String input){
        String[] parsedInput = input.split("/");
        subjOfStudy = parsedInput[0];
        type = parsedInput[1];
        teacher = parsedInput[2];
        lectureHall = parsedInput[3];
        timeOfLesson = parsedInput[4];
    }

    public String GetLessons() {
        return subjOfStudy;
    }

    public String GetTeacher() {
        return teacher;
    }

    public String GetLectureHall() {
        return lectureHall;
    }

    public String GetType() {
        return type;
    }

    public String GetTime(){return timeOfLesson;}
}

public class Timetable {
    private String dayOfTheWeek;
    public Lecture[] lessons = new Lecture[6];

    Timetable (String day){
        this.dayOfTheWeek = day;
    }

    public String GetDay() {
        return dayOfTheWeek;
    }


    //Setters


    /*public void SetDay(String Day) {
        this.DayOfTheWeek = Day;
    }

    public void SetLessons(String[] Lessons) {
        this.Lessons = Lessons;
    }

    public void SetTeacher(String Teacher) {
        this.Teacher = Teacher;
    }

    public void SetLectureHall(String LectureHall) {
        this.LectureHall = LectureHall;
    }

    public void SetType(String Type) {
        this.Type = Type;
    }*/


}
package com.example.max.test;

public class News {
    private String title;
    private String info;

    News(String title, String info){
        this.title = title;
        this.info = info;
    }

    public String ShowTitle(){
        return title;
    }

    public String ShowInfo(){
        return info;
    }
}

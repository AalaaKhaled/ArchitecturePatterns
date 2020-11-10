package com.alyndroid.architecturepatternstutorialshomework.pojo;

public class DataBase {
    public DataBase() {
    }

    public  NumberModel getNumbers(){
        return new NumberModel(4, 2);
    }
}

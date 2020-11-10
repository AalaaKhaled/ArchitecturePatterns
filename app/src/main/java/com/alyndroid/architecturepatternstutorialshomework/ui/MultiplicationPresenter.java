package com.alyndroid.architecturepatternstutorialshomework.ui;

import com.alyndroid.architecturepatternstutorialshomework.pojo.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

public class MultiplicationPresenter {

    MultiplicationView multiplicationView;

    public MultiplicationPresenter(MultiplicationView multiplicationView) {
        this.multiplicationView = multiplicationView;
    }

    public NumberModel getNumber(){
        return new DataBase().getNumbers();
    }
    public int multiplicationOfTwoNumbers(){
        return getNumber().getFirstNum()*getNumber().getSecondNum();
    }
    public void getMultiplication(){
        multiplicationView.onGetMultiplication(multiplicationOfTwoNumbers());
    }

}

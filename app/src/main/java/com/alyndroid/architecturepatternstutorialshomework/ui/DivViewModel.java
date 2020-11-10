package com.alyndroid.architecturepatternstutorialshomework.ui;

import com.alyndroid.architecturepatternstutorialshomework.pojo.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DivViewModel extends ViewModel {
    MutableLiveData<Integer> division = new MutableLiveData<>();
    public NumberModel getNumber(){
        return new DataBase().getNumbers();
    }
    public void divisionOfTwoNumbers(){
        int div =getNumber().getFirstNum()/getNumber().getSecondNum();
        division.setValue(div);

    }

}

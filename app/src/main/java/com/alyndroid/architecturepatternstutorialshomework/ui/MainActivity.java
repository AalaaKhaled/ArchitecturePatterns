package com.alyndroid.architecturepatternstutorialshomework.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.pojo.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener , MultiplicationView{

    @BindView(R.id.plus_button)
    Button plusButton;
    @BindView(R.id.plus_result_textView)
    TextView plusResultTextView;
    @BindView(R.id.mul_button)
    Button mulButton;
    @BindView(R.id.div_button)
    Button divButton;
    @BindView(R.id.mul_result_textView)
    TextView mulResultTextView;
    @BindView(R.id.div_result_textView)
    TextView divResultTextView;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.textView5)
    TextView textView5;

    MultiplicationPresenter multiplicationPresenter;
    DivViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        plusButton.setOnClickListener(this);
        mulButton.setOnClickListener(this);
        divButton.setOnClickListener(this);
        multiplicationPresenter = new MultiplicationPresenter(this);
        viewModel = new ViewModelProvider(this).get(DivViewModel.class);
        viewModel.division.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                divResultTextView.setText(""+integer);
            }
        });

    }

    public NumberModel getNumber() {
        return new DataBase().getNumbers();
    }

    public int AddTwoNumbers(int number1, int number2) {
        return number1 + number2;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.plus_button) {
            plusResultTextView.setText(String.valueOf(AddTwoNumbers(getNumber().getFirstNum(), getNumber().getSecondNum())));
        } else if (v.getId() == R.id.mul_button) {
            multiplicationPresenter.getMultiplication();
        }else if(v.getId() == R.id.div_button){
            viewModel.divisionOfTwoNumbers();
        }
    }

    @Override
    public void onGetMultiplication(int multi) {
        mulResultTextView.setText(""+multi);
    }
}

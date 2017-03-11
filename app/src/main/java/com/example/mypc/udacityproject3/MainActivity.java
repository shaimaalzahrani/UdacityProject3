package com.example.mypc.udacityproject3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // views variables declaration
    EditText textField;
    CheckBox CH1;
    CheckBox CH2;
    CheckBox CH3;
    RadioButton Q1R1;
    RadioButton Q1R2;
    RadioButton Q2R1;
    RadioButton Q2R2;
    RadioButton Q3R1;
    RadioButton Q3R2;

    // score var
    static int numOfCorrectAnswers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // getting views from layout
        textField = (EditText)findViewById(R.id.editText);
        CH1 = (CheckBox)findViewById(R.id.checkBox);
        CH2 = (CheckBox)findViewById(R.id.checkBox2);
        CH3 = (CheckBox)findViewById(R.id.checkBox3);
        Q1R1 = (RadioButton)findViewById(R.id.radioButton);
        Q1R2 = (RadioButton)findViewById(R.id.radioButton2);
        Q2R1 = (RadioButton)findViewById(R.id.radioButton3);
        Q2R2 = (RadioButton)findViewById(R.id.radioButton4);
        Q3R1 = (RadioButton)findViewById(R.id.radioButton5);
        Q3R2 = (RadioButton)findViewById(R.id.radioButton6);

        numOfCorrectAnswers = 0; // to make the value zero in begging

    }

    /***
     * this method will do the whole quiz submition process when the user clicks the submit button
     */

    public void submit(View view){
        if(checkAllFields()){
            // Q1
            if(textField.getText().toString().toUpperCase().equals("ROMA"))
                numOfCorrectAnswers +=1;
            // Q2
            if(CH1.isChecked() && CH2.isChecked() && !CH3.isChecked())
                numOfCorrectAnswers +=1;
            // Q3
            if(Q1R1.isChecked() && !Q1R2.isChecked())
                numOfCorrectAnswers +=1;
            // Q4
            if(Q2R1.isChecked() && !Q2R2.isChecked())
                numOfCorrectAnswers +=1;
            // Q5
            if(!Q3R1.isChecked() && Q3R2.isChecked())
                numOfCorrectAnswers +=1;

            displayInToast("you have answered "+numOfCorrectAnswers+" Out of 5");
            clearAllFields();
        }
        else
            displayInToast("You have to answer all the questions before submitting");
    }

    /***
     * this method is to check wither all the fields of the form are implemented or not
     * it will return true if all implemented and false otherwise
      */

    public boolean checkAllFields(){
        if(!textField.getText().toString().equals(""))
            if(CH1.isChecked() || CH2.isChecked() || CH3.isChecked())
                if(Q1R1.isChecked() || Q1R2.isChecked())
                    if(Q2R1.isChecked() || Q2R2.isChecked())
                        if(Q3R1.isChecked() || Q3R2.isChecked())
                            return true;
        return false;
    }

    /***
     * this method will display the result of the quiz in toast view
     */

    public void displayInToast(String str){
        Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
    }

    /***
     * this method will clear all the views and variables
     */

    public void clearAllFields(){
        // clear views
        textField.setText("");
        CH1.setChecked(false);
        CH2.setChecked(false);
        CH3.setChecked(false);
        Q1R1.setChecked(false);
        Q1R2.setChecked(false);
        Q2R1.setChecked(false);
        Q2R2.setChecked(false);
        Q3R1.setChecked(false);
        Q3R2.setChecked(false);
        //clear vars
        numOfCorrectAnswers = 0;
    }
}

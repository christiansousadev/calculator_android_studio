package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numberZero,numberOne,numberTwo,numberThree,numberFour,numberFive,numberSix,numberSeven,numberEight,numberNine,posNeg,
            dot,clean,division,multiplicate,subtraction,plus,equal;

    private TextView txtExpression,txtResult;

    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StartComponents();

        numberZero.setOnClickListener(this);
        numberOne.setOnClickListener(this);
        numberTwo.setOnClickListener(this);
        numberThree.setOnClickListener(this);
        numberFour.setOnClickListener(this);
        numberFive.setOnClickListener(this);
        numberSix.setOnClickListener(this);
        numberSeven.setOnClickListener(this);
        numberEight.setOnClickListener(this);
        numberNine.setOnClickListener(this);
        dot.setOnClickListener(this);
        division.setOnClickListener(this);
        multiplicate.setOnClickListener(this);
        subtraction.setOnClickListener(this);
        plus.setOnClickListener(this);

        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtExpression.setText("");
                txtResult.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              TextView expression = findViewById(R.id.txt_expression);
              String string = expression.getText().toString();

              if(!string.isEmpty()){
                  byte var0 = 0;
                  int var1 = string.length()-1;
                  String txtExpression = string.substring(var0,var1);
                  expression.setText(txtExpression);
              }
              txtResult.setText("");
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Expression expression = new ExpressionBuilder(txtExpression.getText().toString()).build();
                    double result = expression.evaluate();
                    long longResult = (long) result;

                    if(result == (double)longResult){
                        txtResult.setText((CharSequence)String.valueOf(longResult));
                    }else{
                        txtResult.setText((CharSequence) String.valueOf(result));
                    }
                }catch (Exception e){
                }
            }
        });
    }

    private void StartComponents (){
        numberZero = findViewById(R.id.number_zero);
        numberOne = findViewById(R.id.number_one);
        numberTwo = findViewById(R.id.number_two);
        numberThree = findViewById(R.id.number_three);
        numberFour = findViewById(R.id.number_four);
        numberFive = findViewById(R.id.number_five);
        numberSix = findViewById(R.id.number_six);
        numberSeven = findViewById(R.id.number_seven);
        numberEight = findViewById(R.id.number_eight);
        numberNine = findViewById(R.id.number_nine);
        posNeg = findViewById(R.id.posNeg);
        dot = findViewById(R.id.dot);
        clean = findViewById(R.id.clean);
        division = findViewById(R.id.division);
        multiplicate = findViewById(R.id.multiplicate);
        subtraction = findViewById(R.id.subtraction);
        plus = findViewById(R.id.plus);
        equal = findViewById(R.id.equal);
        txtExpression = findViewById(R.id.txt_expression);
        txtResult = findViewById(R.id.txt_result);
        backspace = findViewById(R.id.backspace);
    }

    public void AddAnExpression(String string,boolean clean_dates){

        if (txtResult.getText().equals("")){
            txtExpression.setText(" ");
        }

        if (clean_dates) {
            txtResult.setText(" ");
            txtExpression.append(string);
        }else{
            txtExpression.append(txtResult.getText());
            txtExpression.append(string);
            txtResult.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.number_zero) {
            AddAnExpression("0", true);
        }
        if (view.getId() == R.id.number_one) {
            AddAnExpression("1", true);
        }
        if (view.getId() == R.id.number_two) {
            AddAnExpression("2", true);
        }
        if (view.getId() == R.id.number_three) {
            AddAnExpression("3", true);
        }
        if (view.getId() == R.id.number_four) {
            AddAnExpression("4", true);
        }
        if (view.getId() == R.id.number_five) {
            AddAnExpression("5", true);
        }
        if (view.getId() == R.id.number_six) {
            AddAnExpression("6", true);
        }
        if (view.getId() == R.id.number_seven) {
            AddAnExpression("7", true);
        }
        if (view.getId() == R.id.number_eight) {
            AddAnExpression("8", true);
        }
        if (view.getId() == R.id.number_nine) {
            AddAnExpression("9", true);
        }
        if (view.getId() == R.id.dot) {
            AddAnExpression(".", false);
        }
        if (view.getId() == R.id.division) {
            AddAnExpression("/", false);
        }
        if (view.getId() == R.id.multiplicate) {
            AddAnExpression("*", false);
        }
        if (view.getId() == R.id.subtraction) {
            AddAnExpression("-", false);
        }
        if (view.getId() == R.id.plus) {
            AddAnExpression("+", false);
        }
    }
}
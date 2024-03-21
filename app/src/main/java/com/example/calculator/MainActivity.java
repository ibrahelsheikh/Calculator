package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView resulttext;
    EditText firstnum, secondnum;
    Button addbutton, subbutton, mulbutton, divbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstnum = findViewById(R.id.firstnumber);
        secondnum = findViewById(R.id.secondnumber);
        resulttext = findViewById(R.id.result);
        addbutton = findViewById(R.id.add);
        subbutton = findViewById(R.id.sub);
        mulbutton = findViewById(R.id.multi);
        divbutton = findViewById(R.id.divide);

        addtwonumber();
        subtwonumber();
        multwonumber();
        divtwonumber();


    }

    private void addtwonumber() {
        int num1, num2, sum;
        num1 = Integer.parseInt(firstnum.getText().toString());
        num2 = Integer.parseInt(secondnum.getText().toString());
        sum = num1 + num2;
        resulttext.setText("Result: " + sum);


    }

    private void subtwonumber() {
        int num1, num2, sub;
        num1 = Integer.parseInt(firstnum.getText().toString());
        num2 = Integer.parseInt(secondnum.getText().toString());
        sub = num1 - num2;
        resulttext.setText("Result: " + sub);
    }

    private void multwonumber() {
        int num1, num2, mul;
        num1 = Integer.parseInt(firstnum.getText().toString());
        num2 = Integer.parseInt(secondnum.getText().toString());
        mul = num1 * num2;
        resulttext.setText("Result: " + mul);
    }

    private void divtwonumber() {
        int num1, num2, div;
        num1 = Integer.parseInt(firstnum.getText().toString());
        num2 = Integer.parseInt(secondnum.getText().toString());
        div = num1 / num2;
        resulttext.setText("Result: " + div);
    }
}

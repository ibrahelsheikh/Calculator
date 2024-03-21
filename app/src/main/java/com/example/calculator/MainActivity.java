package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

        firstnum = findViewById(R.id.num1);
        secondnum = findViewById(R.id.num2);
        resulttext = findViewById(R.id.result);
        addbutton = findViewById(R.id.add);
        subbutton = findViewById(R.id.Subtract);
        mulbutton = findViewById(R.id.multiply);
        divbutton = findViewById(R.id.Divide);

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addtwonumber();
            }
        });

        subbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subtwonumber();
            }
        });

        mulbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multwonumber();
            }
        });

        divbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                divtwonumber();
            }
        });
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
        if(num2 != 0) {
            div = num1 / num2;
            resulttext.setText("Result: " + div);
        } else {
            resulttext.setText("Cannot divide by zero");
        }
    }
}
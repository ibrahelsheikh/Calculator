package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_WRITE_EXTERNAL_STORAGE = 1;
    TextView resulttext;
    EditText firstnum, secondnum;
    Button addbutton, subbutton, mulbutton, divbutton, historybutton;
    File calculationFile;


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
        historybutton = findViewById(R.id.history);



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

        historybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSecondActivity();
            }
        });
    }

    private void addtwonumber() {
        int num1, num2, sum;
        num1 = Integer.parseInt(firstnum.getText().toString());
        num2 = Integer.parseInt(secondnum.getText().toString());
        sum = num1 + num2;
        resulttext.setText("Result: " + sum);
        saveCalculationToFile(num1 + " + " + num2 + " = " + sum);
    }

    private void subtwonumber() {
        int num1, num2, sub;
        num1 = Integer.parseInt(firstnum.getText().toString());
        num2 = Integer.parseInt(secondnum.getText().toString());
        sub = num1 - num2;
        resulttext.setText("Result: " + sub);
        saveCalculationToFile(num1 + " - " + num2 + " = " + sub);
    }

    private void multwonumber() {
        int num1, num2, mul;
        num1 = Integer.parseInt(firstnum.getText().toString());
        num2 = Integer.parseInt(secondnum.getText().toString());
        mul = num1 * num2;
        resulttext.setText("Result: " + mul);
        saveCalculationToFile(num1 + " * " + num2 + " = " + mul);
    }

    private void divtwonumber() {
        float num1, num2, div;
        num1 = Float.parseFloat(firstnum.getText().toString());
        num2 = Float.parseFloat(secondnum.getText().toString());
        if(num2 != 0) {
            div = num1 / num2;
            resulttext.setText("Result: " + div);
            saveCalculationToFile(num1 + " / " + num2 + " = " + div);
        } else {
            resulttext.setText("Cannot divide by zero");
        }
    }


    private void saveCalculationToFile(String calculation) {
        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        ) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_WRITE_EXTERNAL_STORAGE
            );
        } else {
            try {
                String fileName = "calculations.txt";
                calculationFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), fileName);
                FileOutputStream fileOutputStream = new FileOutputStream(calculationFile, true);
                fileOutputStream.write((calculation + "\n").getBytes());
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Unable to save calculation", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode,
            @NonNull String[] permissions,
            @NonNull int[] grantResults
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_WRITE_EXTERNAL_STORAGE) {
            if (grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
                // Call saveCalculationToFile again with the last calculation
                saveCalculationToFile(resulttext.getText().toString());
            } else {
                Toast.makeText(this, "Need permission", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void goToSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
package com.example.calculator;

import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String data = readDataFromFile();
//        Log.d("SecondActivity", "Data: " + data);
        TextView textView = findViewById(R.id.textView2);
        textView.setText(formatData(data));
    }

    private String formatData(String data) {
        String[] dataArr = data.split(" ");
        String num1 = dataArr[0];
        String operation = dataArr[1];
        String num2 = dataArr[2];
        String equalsSign = dataArr[3];
        String result = dataArr[4];
        return num1 + " " + operation + " " + num2 + " " + equalsSign + " " + result + "\n";
    }

    private String readDataFromFile() {
        StringBuilder dataStringBuilder = new StringBuilder();

        try {
            String fileName = "calculations.txt";
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), fileName);

            if (file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    dataStringBuilder.append(line).append(" ");
                }

                bufferedReader.close();
            } else {
                Toast.makeText(this, "No calculation history", Toast.LENGTH_SHORT).show();

            }

        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception, e.g., show an error message to the user
        }
        return dataStringBuilder.toString();
    }
}
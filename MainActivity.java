package com.snjb.myapplicationdemo2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText num1EditText, num2EditText;
    TextView resultTextView;
    Button addButton, subtractButton, multiplyButton, divideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1EditText = findViewById(R.id.editTextNumber1);
        num2EditText = findViewById(R.id.editTextNumber2);
        resultTextView = findViewById(R.id.textViewResult);

        addButton = findViewById(R.id.btnAdd);
        subtractButton = findViewById(R.id.btnSubtract);
        multiplyButton = findViewById(R.id.btnMultiply);
        divideButton = findViewById(R.id.btnDivide);

        addButton.setOnClickListener(v -> performOperation('+'));
        subtractButton.setOnClickListener(v -> performOperation('-'));
        multiplyButton.setOnClickListener(v -> performOperation('*'));
        divideButton.setOnClickListener(v -> performOperation('/'));
    }

    private void performOperation(char operator) {
        String num1Str = num1EditText.getText().toString().trim();
        String num2Str = num2EditText.getText().toString().trim();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(this, "Enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            int num1 = Integer.parseInt(num1Str);
            int num2 = Integer.parseInt(num2Str);
            String result = "";

            switch (operator) {
                case '+':
                    result = "Result: " + (num1 + num2);
                    break;
                case '-':
                    result = "Result: " + (num1 - num2);
                    break;
                case '*':
                    result = "Result: " + (num1 * num2);
                    break;
                case '/':
                    if (num2 == 0) {
                        Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = "Result: " + ((double) num1 / num2);
                    break;
            }

            resultTextView.setText(result);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
        }
    }
}

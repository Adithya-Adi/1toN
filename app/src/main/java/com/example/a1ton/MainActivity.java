package com.example.a1ton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    static EditText fm,too;
    static Spinner s;
    static TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] arraySpinner = new String[] {
                "Prime Number","Factorial","Fibonacci"
        };
        fm = findViewById(R.id.editTextTextPersonName);
        too = findViewById(R.id.editTextTextPersonName3);
        s = findViewById(R.id.spinner2);
        res = findViewById(R.id.textView8);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        final Button btnConvert = findViewById(R.id.button2);
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fm.getText().toString().isEmpty() || too.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter the value", Toast.LENGTH_SHORT).show();
                }
                else {
                    generate();
                }
            }
        });
    }
    public void generate()
    {
        String gen = s.getSelectedItem().toString();
        int from = Integer.parseInt(fm.getText().toString());
        int to = Integer.parseInt(too.getText().toString());

            try {
                if(gen == "Prime Number")
                {
                    List<Integer> primeNumbers = new LinkedList<>();
                    for (int i = from; i <= to; i++) {
                        if (isPrimeBruteForce(i)) {
                            primeNumbers.add(i);
                        }
                    }
                    res.setText(primeNumbers.toString());
                } else if(gen == "Factorial") {
                    List<Integer> factorial = new LinkedList<>();
                    for (int i = from; i <= to; i++) {
                        int result = 1;
                        for (int j = 1; j <= i; j++) {
                            result = result * j;
                        }
                        factorial.add(result);
                    }
                    res.setText(factorial.toString());
                } else if(gen == "Fibonacci") {
                    List<Integer> fibonacci = new LinkedList<>();
                    int a = 0, b = 1, c;
                    for (int i = 0; i < to; i++) {
                        c = a + b;
                        a = b;
                        b = c;
                        if (c >= from) {
                            fibonacci.add(c);
                        }
                    }
                    res.setText(fibonacci.toString());
                } else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            } catch(Exception e) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }

    }
    public static boolean isPrimeBruteForce(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
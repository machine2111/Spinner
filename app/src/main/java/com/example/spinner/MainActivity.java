package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private EditText et1, et2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.txt_num1);
        et2 = (EditText) findViewById(R.id.txt_num2);
        tv1 = (TextView) findViewById(R.id.text_result);
        spinner1 = (Spinner) findViewById(R.id.spinner);

        String[] opciones = {"Sumar", "Restar", "Multiplicar", "Dividir"};

        //ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_jqa, opciones);
        spinner1.setAdapter(adapter);

    }

// Este metodo realiza el calculo

    public void Calcular(View view) {
        String valor1_String = et1.getText().toString();
        String valor2_String = et2.getText().toString();

        int valor1_int = Integer.parseInt(valor1_String);
        int valor2_int = Integer.parseInt(valor2_String);

        String seleccion = spinner1.getSelectedItem().toString();

        if (seleccion.equals("Sumar")) {
            int suma = valor1_int + valor2_int;
            String result = String.valueOf(suma);
            tv1.setText(result);
        } else if (seleccion.equals("Restar")) {
            int resta = valor1_int - valor2_int;
            String result = String.valueOf(resta);
            tv1.setText(result);
        } else if (seleccion.equals("Multiplicar")) {
            int multiplicacion = valor1_int * valor2_int;
            String result = String.valueOf(multiplicacion);
            tv1.setText(result);
        } else if (seleccion.equals("Dividir")) {
            if (valor2_int == 0) {
                Toast.makeText(this, "El segundo valor debe ser diferente de cero", Toast.LENGTH_SHORT).show();
            } else {
                int division = valor1_int / valor2_int;
                String result = String.valueOf(division);
                tv1.setText(result);
            }
        }
    }

}
package com.example.calculatooooor;

import android.content.Intent;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;
import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.pm.PackageManager;
import android.content.Context;
import android.provider.Settings;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    String num1="";
    String op = "+";
    boolean isNewOP = true;
    EditText ed1;



    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.editText);
    }


    public void numberEvent(View view) {
        if(isNewOP)
            ed1.setText("");
        isNewOP = false;
        String number = ed1.getText().toString();
        switch (view.getId()){
            case R.id.bu1:
                number += "1";
                break;

            case R.id.bu2:
                number += "2";
                break;
            case R.id.bu3:
                number += "3";
                break;
            case R.id.bu4:
                number += "4";
                break;
            case R.id.bu5:
                number += "5";
                break;
            case R.id.bu6:
                number += "6";
                break;
            case R.id.bu7:
                number += "7";
                break;
            case R.id.bu8:
                number += "8";
                break;
            case R.id.bu9:
                number += "9";
                break;
            case R.id.bu0:
                number += "0";
                break;
            case R.id.buPunto:
                number += ".";
                break;
        }
        ed1.setText(number);
    }


    public void operatorEvent(View view) {
        isNewOP = true;
        num1 = ed1.getText().toString();
        switch (view.getId()){
            case R.id.buDivision: op="/"; break;
            case R.id.buMultiplicacion: op="*"; break;
            case R.id.buSuma: op="+"; break;
            case R.id.buResta: op="-"; break;
        }
    }

    public void igualEvent(View view) {
        String num2 = ed1.getText().toString();
        double result = 0.0;
        switch (op){
            case "+": result = Double.parseDouble(num1) + Double.parseDouble(num2);
            break;
            case "-": result = Double.parseDouble(num1) - Double.parseDouble(num2);
            break;
            case "/": result = Double.parseDouble(num1) / Double.parseDouble(num2);
            break;
            case "*": result = Double.parseDouble(num1) * Double.parseDouble(num2);
            break;
        }
        ed1.setText(result+"");
    }

    public void limpiarEvent(View view) {
        ed1.setText("0");
        isNewOP = true;
    }

    public void porcentajeEvent(View view) {
        double num = Double.parseDouble(ed1.getText().toString())/100;
        ed1.setText(num+"");
        isNewOP = true;
    }

    public void borrarEvent (View view){
        EditText tv = findViewById(R.id.editText);
        String str = tv.getText().toString();
        str = str.substring(0, str.length()-1);
        tv.setText(str.toString());
    }
}
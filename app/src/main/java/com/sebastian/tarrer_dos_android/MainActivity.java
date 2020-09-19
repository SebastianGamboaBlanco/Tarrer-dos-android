package com.sebastian.tarrer_dos_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.ParameterMetaData;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText x1,y1,x2,y2;
    Button cuadrante,puntoMedio,pendiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x1 = findViewById(R.id.ediTextx1);
        y1 = findViewById(R.id.editTextY1);
        x2 = findViewById(R.id.editTextX2);
        y2 = findViewById(R.id.editTextY2);
        x1.setOnClickListener(this);
        y1.setOnClickListener(this);
        x2.setOnClickListener(this);
        y2.setOnClickListener(this);
        puntoMedio = findViewById(R.id.btnmedio);
        pendiente = findViewById(R.id.btnpendiente);
        cuadrante = findViewById(R.id.btncuadrante);
        puntoMedio.setOnClickListener(this);
        pendiente.setOnClickListener(this);
        cuadrante.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       Random aleatorio = new Random();
       float distancia=0;

        switch (item.getItemId()){
            case R.id.m1:
                x1.setText(String.valueOf(aleatorio.nextInt(100) - 50));
                x2.setText(String.valueOf(aleatorio.nextInt(100) - 50));
                y1.setText(String.valueOf(aleatorio.nextInt(100) - 50));
                y2.setText(String.valueOf(aleatorio.nextInt(100) - 50));
                break;

            case R.id.m2:
                if(TextUtils.isEmpty(x1.getText().toString()) || TextUtils.isEmpty(y1.getText().toString()) ||
                        TextUtils.isEmpty(x2.getText().toString()) || TextUtils.isEmpty(y2.getText().toString())){
                    Toast toast = Toast.makeText(getApplicationContext(), "Los campos no puden estar vacios ", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }else{
                    distancia = (float) Math.sqrt(Math.pow((Integer.parseInt(x2.getText().toString())-Integer.parseInt(x1.getText().toString())),2)+
                            Math.pow((Integer.parseInt(y2.getText().toString())-Integer.parseInt(y1.getText().toString())),2));
                    Toast toast = Toast.makeText(this, "distancia = " + distancia, Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (TextUtils.isEmpty(x1.getText().toString()) || TextUtils.isEmpty(y1.getText().toString()) ||
                TextUtils.isEmpty(x2.getText().toString()) || TextUtils.isEmpty(y2.getText().toString())) {
            Toast toast = Toast.makeText(getApplicationContext(), "Los campos no puden estar vacios ", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }else {
            float valorx=Integer.parseInt(x1.getText().toString());
            float valory=Integer.parseInt(y1.getText().toString());
            float valorx2=Integer.parseInt(x2.getText().toString());
            float valory2=Integer.parseInt(y2.getText().toString());

            switch (v.getId()) {
                case R.id.btnmedio:
                    float x = (valorx + valorx2) / 2;
                    float y = (valory + valory2) / 2;
                    Toast toast = Toast.makeText(this, "Punto medio = " + x + " , " + y, Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    break;
                case R.id.btnpendiente:
                    float pen=(valory2-valory)/(valorx2-valorx);
                    Toast toast1 = Toast.makeText(this, "Pendiente= "+ pen, Toast.LENGTH_LONG);
                    toast1.setGravity(Gravity.CENTER, 0, 0);
                    toast1.show();
                    break;
                case R.id.btncuadrante:
                    if (valorx > 0 && valory > 0){
                        Toast toast2 = Toast.makeText(this, "El punto "+ valorx+","+ valory + " Esta en el Cuadrante= "+ "Primero", Toast.LENGTH_LONG);
                        toast2.setGravity(Gravity.CENTER, 0, 0);
                        toast2.show();
                    }else if (valorx < 0 && valory > 0){
                        Toast toast2 = Toast.makeText(this, "El punto "+ valorx+"," + valory + " Esta en el Cuadrante= "+ "Segundo", Toast.LENGTH_LONG);
                        toast2.setGravity(Gravity.CENTER, 0, 0);
                        toast2.show();
                    }else if (valorx < 0 && valory < 0){
                        Toast toast2 = Toast.makeText(this, "El punto "+ valorx+"," + valory + " Esta en el Cuadrante= "+ "Tercero", Toast.LENGTH_LONG);
                        toast2.setGravity(Gravity.CENTER, 0, 0);
                        toast2.show();
                    }else if (valorx > 0 && valory < 0){
                        Toast toast2 = Toast.makeText(this, "El punto "+ valorx+"," + valory + " Esta en el Cuadrante= "+ "Cuarto", Toast.LENGTH_LONG);
                        toast2.setGravity(Gravity.CENTER, 0, 0);
                        toast2.show();
                    }

                    if (valorx2 > 0 && valory2 > 0){
                        Toast toast2 = Toast.makeText(this, "El punto "+ valorx2+"," + valory2 + " Esta en el Cuadrante= "+ "Primero", Toast.LENGTH_LONG);
                        toast2.setGravity(Gravity.CENTER, 0, 0);
                        toast2.show();
                    }
                    else if (valorx2 < 0 && valory2 > 0){
                        Toast toast2 = Toast.makeText(this, "El punto "+ valorx2+"," + valory2 + " Esta en el Cuadrante= "+ "Segundo", Toast.LENGTH_LONG);
                        toast2.setGravity(Gravity.CENTER, 0, 0);
                        toast2.show();
                    }
                    else if (valorx2 < 0 && valory2 < 0){
                        Toast toast2 = Toast.makeText(this, "El punto "+ valorx2+"," + valory2 + " Esta en el Cuadrante= "+ "Tercero", Toast.LENGTH_LONG);
                        toast2.setGravity(Gravity.CENTER, 0, 0);
                        toast2.show();
                    }
                    else if (valorx2 > 0 && valory2 < 0){
                        Toast toast2 = Toast.makeText(this, "El punto "+ valorx2+"," + valory2 + " Esta en el Cuadrante= "+ "Cuarto", Toast.LENGTH_LONG);
                        toast2.setGravity(Gravity.CENTER, 0, 0);
                        toast2.show();
                    }
                    break;
            }
        }
    }
}

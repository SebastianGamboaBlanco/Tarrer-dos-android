package com.sebastian.tarrer_dos_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {

    }
}

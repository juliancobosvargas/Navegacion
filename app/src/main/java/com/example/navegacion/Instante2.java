package com.example.navegacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Instante2 extends AppCompatActivity {

    private static final long demora = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instante2);

        //Tarea del Temporizador
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                irActividadNueva();
            }
        };
        //temporizador ejecuta la instantanea = splash
        Timer temporizador = new Timer();
        temporizador.schedule(tarea,demora);

    }

    private void irActividadNueva() {
        Intent intento = new Intent(this, MainActivity.class);
        startActivity(intento);
        finish();
    }
}
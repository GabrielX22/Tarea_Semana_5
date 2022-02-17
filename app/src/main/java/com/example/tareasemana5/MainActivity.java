package com.example.tareasemana5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

ArrayList lista = new ArrayList<>();
private TextView score;
private ImageView bandera;
private TextView puntos;
private Button opcion1;
private Button opcion2;
private Button opcion3;
private ImageView logobandera;
private ImageView logonombre;
private ImageButton btninicio;
private ImageButton btnsalir;
private TextView textoacierto;
private TextView textoerror;
private ImageView result;
int contador = 0;
int puntaje = 0;
int aciertos = 0;
int errores = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score = (TextView)findViewById(R.id.txtpuntos);
        bandera = (ImageView)findViewById(R.id.bandera);
        puntos = (TextView)findViewById(R.id.txtpunt);
        opcion1 = (Button) findViewById(R.id.btnprimera);
        opcion2 = (Button) findViewById(R.id.btnsegunda);
        opcion3 = (Button) findViewById(R.id.btntercera);
        logobandera = (ImageView)findViewById(R.id.imagelogo);
        logonombre = (ImageView)findViewById(R.id.imagenombre);
        btninicio = (ImageButton)findViewById(R.id.iniciar);
        textoacierto = (TextView)findViewById(R.id.txtacierto);
        textoerror = (TextView)findViewById(R.id.txterrores);
        btnsalir = (ImageButton) findViewById(R.id.imagesalir);
        result = (ImageView) findViewById(R.id.imageres);


        textoacierto.setVisibility(View.GONE);
        textoerror.setVisibility(View.GONE);
        score.setVisibility(View.GONE);
result.setVisibility(View.GONE);
btnsalir.setVisibility(View.GONE);
bandera.setVisibility(View.GONE);
puntos.setVisibility(View.GONE);
opcion1.setVisibility(View.GONE);
opcion2.setVisibility(View.GONE);
opcion3.setVisibility(View.GONE);

lista.add(new Preguntas("Cual es esta bandera?","Paraguay","Paraguay","Uruguay","Argentina"));
lista.add(new Preguntas("Cual es esta bandera?","Suecia","Suiza","Suecia","Sudafrica"));
lista.add(new Preguntas("Cual es esta bandera?","Australia","Nueva Zelanda","Australia","Inglaterra"));
lista.add(new Preguntas("Cual es esta bandera?","Corea del Norte","Corea del Norte","Corea del Sur","China"));

contador = 0;
cargar(contador);


    }
    public void cargar(int n){
        final Preguntas q = (Preguntas) lista.get(n);
        score.setText("" + (n + 1) + " " + q.getPreg());
        if (contador == 0){
            bandera.setImageResource(R.drawable.paraguay);
        }
        if (contador == 1){
            bandera.setImageResource(R.drawable.suecia);
        }
        if (contador == 2){
            bandera.setImageResource(R.drawable.australia);
        }
        if (contador == 3){
            bandera.setImageResource(R.drawable.corea);
        }
        opcion1.setText("" + q.getOpcion1());
        opcion2.setText("" + q.getOpcion2());
        opcion3.setText("" + q.getOpcion3());

        btnsalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btninicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logobandera.setVisibility(View.GONE);
                logonombre.setVisibility(View.GONE);
                btninicio.setVisibility(View.GONE);
                textoacierto.setVisibility(View.VISIBLE);
                textoerror.setVisibility(View.VISIBLE);
                score.setVisibility(View.VISIBLE);
                bandera.setVisibility(View.VISIBLE);
                puntos.setVisibility(View.VISIBLE);
                opcion1.setVisibility(View.VISIBLE);
                opcion2.setVisibility(View.VISIBLE);
                opcion3.setVisibility(View.VISIBLE);
            }
        });

        opcion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (opcion1.getText().equals(q.getCorrecta())){
                    puntos.setText("Puntuacion: " + (puntaje = puntaje+ 1));
                    textoacierto.setText("Aciertos: " + (aciertos = aciertos + 1));
                    Toast.makeText(MainActivity.this, "Respuesta Correcta", Toast.LENGTH_SHORT).show();
                    if (contador < (lista.size() - 1)){
                        contador++;
                        cargar(contador);
                    }else{
                        logobandera.setVisibility(View.GONE);
                        logonombre.setVisibility(View.GONE);
                        btninicio.setVisibility(View.GONE);
                        score.setVisibility(View.GONE);
                        btnsalir.setVisibility(View.GONE);
                        bandera.setVisibility(View.GONE);
                        puntos.setVisibility(View.VISIBLE);
                        opcion1.setVisibility(View.GONE);
                        opcion2.setVisibility(View.GONE);
                        opcion3.setVisibility(View.GONE);
                        btnsalir.setVisibility(View.VISIBLE);
                        result.setVisibility(View.VISIBLE);
                    }
                }else{
                    textoerror.setText("Errores: " + (errores = errores + 1));
                    if(puntaje == 1){
                        puntos.setText("Puntuacion: " + (puntaje = puntaje - 1));
                    }
                    else if (puntaje > 0){
                        puntos.setText("Puntuacion: " + (puntaje = puntaje - 2));
                    }
                    else {
                        puntos.setText("Puntuacion: " + (puntaje = puntaje - 0));
                    }
                    Toast.makeText(MainActivity.this, "Respuesta Incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        });


        opcion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (opcion2.getText().equals(q.getCorrecta())){
                    puntos.setText("Puntuacion: " + (puntaje = puntaje + 1));
                    textoacierto.setText("Aciertos: " + (aciertos = aciertos + 1));
                    Toast.makeText(MainActivity.this, "Respuesta Correcta", Toast.LENGTH_SHORT).show();
                    if (contador < (lista.size() - 1)){
                        contador++;
                        cargar(contador);
                    }else{
                        logobandera.setVisibility(View.GONE);
                        logonombre.setVisibility(View.GONE);
                        btninicio.setVisibility(View.GONE);
                        score.setVisibility(View.GONE);
                        btnsalir.setVisibility(View.GONE);
                        bandera.setVisibility(View.GONE);
                        puntos.setVisibility(View.VISIBLE);
                        opcion1.setVisibility(View.GONE);
                        opcion2.setVisibility(View.GONE);
                        opcion3.setVisibility(View.GONE);
                        btnsalir.setVisibility(View.VISIBLE);
                        result.setVisibility(View.VISIBLE);
                    }
                }else{
                    textoerror.setText("Errores: " + (errores = errores + 1));
                    if(puntaje == 1){
                        puntos.setText("Puntuacion: " + (puntaje = puntaje - 1));
                    }
                    else if (puntaje > 0){
                        puntos.setText("Puntuacion: " + (puntaje = puntaje - 2));
                    }
                    else {
                        puntos.setText("Puntuacion: " + (puntaje = puntaje - 0));
                    }
                    Toast.makeText(MainActivity.this, "Respuesta Incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        });

        opcion3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (opcion3.getText().equals(q.getCorrecta())){
                    puntos.setText("Puntuacion: " + (puntaje = puntaje + 1));
                    textoacierto.setText("Aciertos: " + (aciertos = aciertos + 1));
                    Toast.makeText(MainActivity.this, "Respuesta Correcta", Toast.LENGTH_SHORT).show();
                    if (contador < (lista.size() - 1)){
                        contador++;
                        cargar(contador);
                    }else{
                        logobandera.setVisibility(View.GONE);
                        logonombre.setVisibility(View.GONE);
                        btninicio.setVisibility(View.GONE);
                        score.setVisibility(View.GONE);
                        btnsalir.setVisibility(View.GONE);
                        bandera.setVisibility(View.GONE);
                        puntos.setVisibility(View.VISIBLE);
                        opcion1.setVisibility(View.GONE);
                        opcion2.setVisibility(View.GONE);
                        opcion3.setVisibility(View.GONE);
                        btnsalir.setVisibility(View.VISIBLE);
                        result.setVisibility(View.VISIBLE);
                    }
                }else{
                    textoerror.setText("Errores: " + (errores = errores + 1));
                    if(puntaje == 1){
                        puntos.setText("Puntuacion: " + (puntaje = puntaje - 1));
                    }
                    else if (puntaje > 0){
                        puntos.setText("Puntuacion: " + (puntaje = puntaje - 2));
                    }
                    else {
                        puntos.setText("Puntuacion: " + (puntaje = puntaje - 0));
                    }
                    Toast.makeText(MainActivity.this, "Respuesta Incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
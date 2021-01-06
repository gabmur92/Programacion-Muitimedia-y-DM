package com.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button Uno,Dos,Tres,Cuatro,Cinco,Seis,Siete,Ocho,Nueve,Cero;
    private Button Suma,Resta,Multiplicacion,Division,Limpiar,Borrar,Igual,Punto;
    private TextView Etiqueta;
    String mostrar,operador,reserva;
    double resultado;
    //Private TextView Etiqueta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    Cero = (Button)findViewById(R.id.Cero);
    Uno = (Button)findViewById(R.id.Uno);
    Dos = (Button)findViewById(R.id.Dos);
    Tres = (Button)findViewById(R.id.Tres);
    Cuatro = (Button)findViewById(R.id.Cuatro);
    Cinco = (Button)findViewById(R.id.Cinco);
    Seis = (Button)findViewById(R.id.Seis);
    Siete = (Button)findViewById(R.id.Siete);
    Ocho = (Button)findViewById(R.id.Ocho);
    Nueve = (Button)findViewById(R.id.Nueve);
    Suma = (Button)findViewById(R.id.Suma);
    Resta = (Button)findViewById(R.id.Resta);
    Multiplicacion = (Button)findViewById(R.id.Multiplica);
    Division = (Button)findViewById(R.id.Divide);
    Limpiar = (Button)findViewById(R.id.Clean);
    Borrar = (Button)findViewById(R.id.Borrar);
    Etiqueta = (TextView)findViewById(R.id.Etiqueta);
    Punto = (Button)findViewById(R.id.Punto);
    Igual = (Button)findViewById(R.id.Igual);

    Cero.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            mostrar = Etiqueta.getText().toString();
            mostrar = mostrar + "0";
            Etiqueta.setText(mostrar);
        }
    });
    Uno.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            mostrar = Etiqueta.getText().toString();
            mostrar = mostrar + "1";
            Etiqueta.setText(mostrar);
        }
    });

    Dos.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            mostrar = Etiqueta.getText().toString();
            mostrar = mostrar + "2";
            Etiqueta.setText(mostrar);
        }
    });

    Tres.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            mostrar = Etiqueta.getText().toString();
            mostrar = mostrar + "3";
            Etiqueta.setText(mostrar);
        }
    });

    Cuatro.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            mostrar = Etiqueta.getText().toString();
            mostrar = mostrar + "4";
            Etiqueta.setText(mostrar);
        }
    });

    Cinco.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
            mostrar = Etiqueta.getText().toString();
            mostrar = mostrar + "5";
            Etiqueta.setText(mostrar);
        }
    });

    Seis.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
            mostrar = Etiqueta.getText().toString();
            mostrar = mostrar + "6";
            Etiqueta.setText(mostrar);
        }
    });

    Siete.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
            mostrar = Etiqueta.getText().toString();
            mostrar = mostrar + "7";
            Etiqueta.setText(mostrar);
        }
    });

    Ocho.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
            mostrar = Etiqueta.getText().toString();
            mostrar = mostrar + "8";
            Etiqueta.setText(mostrar);
        }
    });

    Nueve.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
            mostrar = Etiqueta.getText().toString();
            mostrar = mostrar + "9";
            Etiqueta.setText(mostrar);
        }
    });

    Suma.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
            reserva = Etiqueta.getText().toString();
            operador = "+";
            Etiqueta.setText("");
        }
    });

    Resta.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
            reserva = Etiqueta.getText().toString();
            operador = "-";
            Etiqueta.setText("");
        }
    });

    Multiplicacion.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
            reserva = Etiqueta.getText().toString();
            operador = "*";
            Etiqueta.setText("");
        }
    });

    Division.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
            reserva = Etiqueta.getText().toString();
            operador = "/";
            Etiqueta.setText("");
        }
    });

    Punto.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
            mostrar = Etiqueta.getText().toString();
            mostrar = mostrar + ".";
            Etiqueta.setText(mostrar);
        }
    });

    Limpiar.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
            mostrar = "";
            Etiqueta.setText(mostrar);
            reserva = "";
            operador = "";
        }
    });

    Borrar.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
            mostrar = Etiqueta.getText().toString();
            mostrar = mostrar.substring(0,mostrar.length()-1);
            Etiqueta.setText(mostrar);
        }
    });

    Igual.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
            mostrar = Etiqueta.getText().toString();
            mostrar = mostrar + "1";
            if(operador.equals("-")){
                resultado = Double.parseDouble(reserva) - Double.parseDouble(Etiqueta.getText().toString());
                Etiqueta.setText(String.valueOf(resultado));
            }
            if(operador.equals("+")){
                resultado = Double.parseDouble(reserva) + Double.parseDouble(Etiqueta.getText().toString());
                Etiqueta.setText(String.valueOf(resultado));
            }
            if(operador.equals("/")){
                resultado = Double.parseDouble(reserva) / Double.parseDouble(Etiqueta.getText().toString());
                Etiqueta.setText(String.valueOf(resultado));
            }
            if(operador.equals("*")){
                resultado = Double.parseDouble(reserva) * Double.parseDouble(Etiqueta.getText().toString());
                Etiqueta.setText(String.valueOf(resultado));
            }
        }
    });
    }
}

package com.perrete.fragmentocalculadora;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class calc extends Fragment {
    private Button Uno,Dos,Tres,Cuatro,Cinco,Seis,Siete,Ocho,Nueve,Cero;
    private Button Suma,Resta,Multiplicacion,Division,Limpiar,Borrar,Igual,Punto;
    private TextView Etiqueta;
    String mostrar,operador,reserva;
    double resultado;

    public calc() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calc, container, false);

        Cero = (Button)view.findViewById(R.id.Cero);
        Uno = (Button)view.findViewById(R.id.Uno);
        Dos = (Button)view.findViewById(R.id.Dos);
        Tres = (Button)view.findViewById(R.id.Tres);
        Cuatro = (Button)view.findViewById(R.id.Cuatro);
        Cinco = (Button)view.findViewById(R.id.Cinco);
        Seis = (Button)view.findViewById(R.id.Seis);
        Siete = (Button)view.findViewById(R.id.Siete);
        Ocho = (Button)view.findViewById(R.id.Ocho);
        Nueve = (Button)view.findViewById(R.id.Nueve);
        Suma = (Button)view.findViewById(R.id.Suma);
        Resta = (Button)view.findViewById(R.id.Resta);
        Multiplicacion = (Button)view.findViewById(R.id.Multiplica);
        Division = (Button)view.findViewById(R.id.Divide);
        Limpiar = (Button)view.findViewById(R.id.Clean);
        Borrar = (Button)view.findViewById(R.id.Borrar);
        Etiqueta = (TextView)view.findViewById(R.id.Etiqueta);
        Punto = (Button)view.findViewById(R.id.Punto);
        Igual = (Button)view.findViewById(R.id.Igual);

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
        return view;
    }
}

package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {
    Spinner miSpinner;
    final static String semana[]={"lunes","martes","miercoles","jueves","viernes","sabado","domingo"};


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String mensaje;

        miSpinner=(Spinner)findViewById(R.id.CmbOpciones) ;
        ArrayAdapter<String> adaptador =new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,semana);

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        miSpinner.setAdapter(adaptador);

        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView arg0, View arg1,int position,long id){
                String mensaje="";
                mensaje="Item clicked=>" +semana[position];
                showToast(mensaje);

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView){
            }
        });
    }
    public  void showToast(String text){
        Toast.makeText(this,text, Toast.LENGTH_SHORT).show();
    }
}
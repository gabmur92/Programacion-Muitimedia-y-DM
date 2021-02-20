package com.m.matricula;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.m.matricula.alumnoslist.Alumnos;

import com.m.matricula.asignaturalist.Asignatura;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnalumno = (Button) findViewById(R.id.alumnos);
        Button btnasignatura = (Button) findViewById(R.id.asignaturas);
        btnalumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Alumnos.class);
                startActivityForResult(intent, 0);
            }
        });
        btnasignatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Asignatura.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}

package com.m.matricula;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.EditText;

import com.m.matricula.alumnoslist.AlumnosListViewModel;
import com.m.matricula.data.entities.AlumnosList;

import java.util.UUID;

public class AddAlumnosListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alumnos_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewModelProvider.AndroidViewModelFactory factory
                = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        AlumnosListViewModel vm = new ViewModelProvider(this, factory)
                .get(AlumnosListViewModel.class);

        setupCreateButton(vm);
    }
    private void setupCreateButton(AlumnosListViewModel vm) {
        findViewById(R.id.create_button).setOnClickListener(
                view -> {
                    // Obtener valor del campo de texto
                    EditText nombreField =  findViewById(R.id.nombre_field);
                    EditText apellidosField =  findViewById(R.id.apellidos_field);
                    EditText dniField =  findViewById(R.id.dni_field);
                    String nombre = nombreField.getText().toString();
                    String apellidos = apellidosField.getText().toString();
                    String dni = dniField.getText().toString();

                    // Ignorar acción si hay 0 caracteres
                    if (nombre.isEmpty()) {
                        return;
                    }

                    // Crear entidad y guardarla
                    String id = UUID.randomUUID().toString();
                    AlumnosList alumnosList = new AlumnosList(id, nombre, apellidos, dni);
                    vm.insert(alumnosList);

                    // Ir a la lista
                    finish();
                });
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}

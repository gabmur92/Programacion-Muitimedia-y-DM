package com.m.matricula;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.EditText;


import com.m.matricula.asignaturalist.AsignaturasListViewModel;
import com.m.matricula.data.entities.AsignaturasList;

import java.util.UUID;

public class AddAsignaturasListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_asignaturas_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewModelProvider.AndroidViewModelFactory factory
                = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        AsignaturasListViewModel vm = new ViewModelProvider(this, factory)
                .get(AsignaturasListViewModel.class);

        setupCreateButton(vm);
    }
    private void setupCreateButton(AsignaturasListViewModel vm) {
        findViewById(R.id.create_button_asignatura).setOnClickListener(
                view -> {
                    // Obtener valor del campo de texto
                    EditText nombreField =  findViewById(R.id.nombre_field_asignatura);
                    EditText idField =  findViewById(R.id.id_field_asignatura);

                    String nombre = nombreField.getText().toString();
                    String id = idField.getText().toString();

                    // Ignorar acción si hay 0 caracteres
                    if (nombre.isEmpty()) {
                        return;
                    }

                    // Crear entidad y guardarla
                 //  String id = UUID.randomUUID().toString();
                    AsignaturasList asignaturasList = new AsignaturasList(id, nombre);
                    vm.insert(asignaturasList);

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

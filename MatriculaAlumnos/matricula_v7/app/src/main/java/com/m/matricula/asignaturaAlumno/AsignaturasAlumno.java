package com.m.matricula.asignaturaAlumno;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.m.matricula.AddAsignaturasListActivity;
import com.m.matricula.R;
import com.m.matricula.asignaturalist.AsignaturaListAdapter;
import com.m.matricula.asignaturalist.AsignaturaListViewModel;

public class AsignaturasAlumno extends AppCompatActivity {
    private AsignaturaListViewModel mAViewModel;
    private RecyclerView mList;
    private AsignaturaListAdapter mAAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignaturas_alumno);
        ViewModelProvider.AndroidViewModelFactory factory =
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        mAViewModel = new ViewModelProvider(this, factory)
                .get(AsignaturaListViewModel.class);

        setupList();

        setupFab();
    }
    private void setupList() {
        mList = findViewById(R.id.list);
        mAAdapter = new AsignaturaListAdapter();
        mList.setAdapter(mAAdapter);
        mAViewModel.getAsignaturasLists().observe(this, mAAdapter::setItems);
    }

    private void setupFab() {
        findViewById(R.id.floating_action_button_asignatura)
                .setOnClickListener(view -> addNewAsignaturasList());

    }
    private void addNewAsignaturasList() {
        startActivity(new Intent(this, AddAsignaturasListActivity.class));
    }
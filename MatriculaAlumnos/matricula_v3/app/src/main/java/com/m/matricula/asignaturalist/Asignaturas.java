package com.m.matricula.asignaturalist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.m.matricula.AddAsignaturasListActivity;
import com.m.matricula.R;

public class Asignaturas extends AppCompatActivity {
    private AsignaturasListViewModel mViewModel;
    private RecyclerView mList;
    private AsignaturasListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignaturas);

        ViewModelProvider.AndroidViewModelFactory factory =
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        mViewModel = new ViewModelProvider(this, factory)
                .get(AsignaturasListViewModel.class);

        setupList();

        setupFab();
    }
    private void setupList() {
        mList = findViewById(R.id.list_asignatura);
        mAdapter = new AsignaturasListAdapter();
        mList.setAdapter(mAdapter);
        mViewModel.getAsignaturasLists().observe(this, mAdapter::setItems);
    }

    private void setupFab() {
        findViewById(R.id.floating_action_button_asignatura)
                .setOnClickListener(view -> addNewAsignaturasList());
    }

    private void addNewAsignaturasList() {
        startActivity(new Intent(this, AddAsignaturasListActivity.class));
    }
}

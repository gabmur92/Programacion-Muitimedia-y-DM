package com.m.matricula.alumnoslist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.m.matricula.AddAlumnosListActivity;
import com.m.matricula.MainActivity;
import com.m.matricula.R;
import com.m.matricula.data.MatriculaListDatabase;
import com.m.matricula.data.entities.AlumnosList;
//import com.m.matricula.data.relationentities.AlumnoWhithColaborators;
//import com.m.matricula.edit.EditAlumnosListActivity;

import java.util.List;

public class Alumnos extends AppCompatActivity {
    private AlumnosListViewModel mViewModel;
    private RecyclerView mList;
    private AlumnosListAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos);

     //   TextView dbText = findViewById(R.id.text);

        ViewModelProvider.AndroidViewModelFactory factory =
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        mViewModel = new ViewModelProvider(this, factory)
                .get(AlumnosListViewModel.class);

        setupList();

        setupFab();

    /*    mViewModel.getAlumnosLists().observe(this, shoppingLists -> {
                    StringBuilder sb = new StringBuilder();
                    for (AlumnosList list : shoppingLists) {
                        sb.append(list.getNombre()).append("\n");
                        sb.append(list.getApellidos()).append("\n");
                        sb.append(list.getDni()).append("\n");
                    }
                    dbText.setText(sb.toString());
                }
        );*/

    }
    private void setupList() {
        mList = findViewById(R.id.list);
        mAdapter = new AlumnosListAdapter();
        mList.setAdapter(mAdapter);
        mViewModel.getAlumnosLists().observe(this, mAdapter::setItems);

    /*    mAdapter.setItemListener(new AlumnosListAdapter.ItemListener() {
            @Override
            public void onClick(AlumnosList alumnosList) {
               // editShoppingList(shoppingList);
            }

            @Override
            public void onDeleteIconClicked(AlumnosList alumnoList) {

            }

            @Override
            public void onDeleteIconClicked(AlumnoWhithColaborators alumnosList) {
                mViewModel.deleteAlumnosList(alumnosList);
            }
        });*/
    }

    private void setupFab() {
        findViewById(R.id.floating_action_button)
                .setOnClickListener(view -> addNewShoppingList());

    }
   /* private void editShoppingList(AlumnosListForList shoppingList) {
        Intent intent = new Intent(
                MainActivity.this,
                EditAlumnosListActivity.class);
        intent.putExtra(EditAlumnosListActivity.EXTRA_SHOPPING_LIST_ID,
                shoppingList.id);
        startActivity(intent);
    }*/
    private void addNewShoppingList() {
        startActivity(new Intent(this, AddAlumnosListActivity.class));
    }
}

package com.m.matricula.alumnoslist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.m.matricula.AddAlumnosListActivity;
import com.m.matricula.MainActivity;
import com.m.matricula.R;
import com.m.matricula.asignaturaAlumno.AsignaturasAlumno;
import com.m.matricula.data.entities.AlumnosList;
import com.m.matricula.data.entities.AlumnosListForList;
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

        //TextView dbText = findViewById(R.id.db_text);

        ViewModelProvider.AndroidViewModelFactory factory =
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        mViewModel = new ViewModelProvider(this, factory)
                .get(AlumnosListViewModel.class);

        setupList();

        setupFab();

      /*  mViewModel.getAlumnosLists().observe(this, shoppingLists -> {
                    StringBuilder sb = new StringBuilder();
                    for (AlumnosList list : shoppingLists) {
                        sb.append(list.getNombre()).append("\n");
                        sb.append(list.getApellidos()).append("\n");
                        sb.append(list.getDni()).append("\n");
                    }
                    dbText.setText(sb.toString());
                }
        );*/

      //iniciamos boton para pasar a la actividad para añadir asignaturas
        Button btnasignaturasAlumno = (Button) findViewById(R.id.go_button);

        btnasignaturasAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), AsignaturasAlumno.class);
                startActivityForResult(intent, 0);
            }
        });
    }
  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (R.id.delete_all == itemId) {
            //llamamos al metodo en el view model
            mViewModel.deleteAll();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
    private void setupList() {
        mList = findViewById(R.id.list);
        mAdapter = new AlumnosListAdapter();
        mList.setAdapter(mAdapter);
        mViewModel.getAlumnosLists().observe(this, mAdapter::setItems);

      /*  mAdapter.setItemListener(new AlumnosListAdapter.ItemListener() {
            @Override
            public void onClick(AlumnosListForList alumnosList) {
               // editShoppingList(shoppingList);
            }

            @Override
            public void onDeleteIconClicked(AlumnosListForList alumnosList) {
                mViewModel.deleteAlumnosList(alumnosList);
            }

        });*/
    }

    private void setupFab() {
        findViewById(R.id.floating_action_button)
                .setOnClickListener(view -> addNewAlumnosList());

    }

   /* private void editShoppingList(AlumnosListForList shoppingList) {
        Intent intent = new Intent(
                MainActivity.this,
                EditAlumnosListActivity.class);
        intent.putExtra(EditAlumnosListActivity.EXTRA_SHOPPING_LIST_ID,
                shoppingList.id);
        startActivity(intent);
    }*/
    private void addNewAlumnosList() {
        startActivity(new Intent(this, AddAlumnosListActivity.class));
    }


}

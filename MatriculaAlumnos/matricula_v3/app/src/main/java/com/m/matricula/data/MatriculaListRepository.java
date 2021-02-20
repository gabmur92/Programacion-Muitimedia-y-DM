package com.m.matricula.data;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.m.matricula.data.daos.AlumnosListDao;
import com.m.matricula.data.daos.AsignaturasListDao;
import com.m.matricula.data.entities.AlumnosList;
import com.m.matricula.data.entities.AsignaturasList;
//import com.m.matricula.partialentities.AlumnosListId;

import java.util.List;

public class MatriculaListRepository {
    private final LiveData<List<AlumnosList>> mAlumnosLists;
      private final LiveData<List<AsignaturasList>> mAsignaturasLists;

    private final AlumnosListDao mAlumnosListDao;
     private final AsignaturasListDao mAsignaturasListDao;

    public MatriculaListRepository(Context context) {
        MatriculaListDatabase db = MatriculaListDatabase.getInstance(context);

        mAlumnosListDao = db.alumnosListDao();
        mAlumnosLists = mAlumnosListDao.getAll();

          mAsignaturasListDao=db.asignaturasListDao();
          mAsignaturasLists=mAsignaturasListDao.getAll();

    }

    public LiveData<List<AlumnosList>> getAllAlumnosLists() {
        return mAlumnosLists;
    }
      public LiveData<List<AsignaturasList>> getAllAsignaturasLists(){return mAsignaturasLists;}
   /* public LiveData<AlumnosList> getShoppingList(String id){
        return mAlumnosListDao.getAlumnosList(id);
    }*/
    public void insert(final AlumnosList alumnosList) {
        MatriculaListDatabase.dbExecutor.execute(
                () -> mAlumnosListDao.insert(alumnosList)
        );
    }
  /*  public void deleteAlumnosList(AlumnosList id) {
        MatriculaListDatabase.dbExecutor.execute(
                () -> mAlumnosListDao.deleteAlumnosList(id)
        );
    }*/
    public void insert(final AsignaturasList asignaturasList){
        MatriculaListDatabase.dbExecutor.execute(
                () -> mAsignaturasListDao.insert(asignaturasList)
        );
    }
}

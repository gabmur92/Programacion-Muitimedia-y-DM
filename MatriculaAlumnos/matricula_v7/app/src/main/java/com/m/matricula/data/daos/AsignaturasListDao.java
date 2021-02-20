package com.m.matricula.data.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


import com.m.matricula.data.entities.AsignaturasList;

import java.util.List;

@Dao
public interface AsignaturasListDao {
    @Query("SELECT * FROM asignaturas_list")
    LiveData<List<AsignaturasList>> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAsignatura(AsignaturasList asignaturasList);

    @Update
    void updateAsignaturasList(AsignaturasList asignaturasList);

    @Update
    void updateAsignaturasLists(List<AsignaturasList> asignaturasList);

    // @Delete(entity = AlumnosList.class)
    // void deleteAlumnosList(AlumnoListId alumnoList);

    // @Query("SELECT id FROM alumnos_list")
    // LiveData<List<AlumnosListForList>> getAllId();

    // @Query("DELETE FROM alumnos_list WHERE id=:id")
    //void deleteAlumnosList(String id);

//eliminamos toda la lista en la bd
    //  @Query("DELETE  FROM alumnos_list")
    //  void deleteAllAlumnosLists();


    // @Query("DELETE FROM alumnos_list WHERE id=:id")
    // void deleteShoppingList(String id);

}

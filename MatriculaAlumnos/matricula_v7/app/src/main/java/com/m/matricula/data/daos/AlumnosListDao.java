package com.m.matricula.data.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.m.matricula.data.entities.AlumnoListId;
import com.m.matricula.data.entities.AlumnosList;
import com.m.matricula.data.entities.AlumnosListForList;
//import com.m.matricula.partialentities.AlumnosListId;

import java.util.List;

@Dao
public interface AlumnosListDao {
    @Query("SELECT * FROM alumnos_list")
    LiveData<List<AlumnosList>> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(AlumnosList shoppingList);

    @Update
    void updateAlumnosList(AlumnosList alumnosList);

    @Update
    void updateAlumnosLists(List<AlumnosList> alumnosLists);

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

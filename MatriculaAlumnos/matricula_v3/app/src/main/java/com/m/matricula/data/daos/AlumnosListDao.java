package com.m.matricula.data.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.m.matricula.data.entities.AlumnosList;
//import com.m.matricula.partialentities.AlumnosListId;

import java.util.List;

@Dao
public interface AlumnosListDao {
    @Query("SELECT * FROM alumnos_list")
    LiveData<List<AlumnosList>> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(AlumnosList shoppingList);

   /* @Insert(onConflict = OnConflictStrategy.IGNORE, entity = AlumnosList.class)
    void partialInsert(AlumnosListInsert shoppingList);

    @Insert(onConflict = OnConflictStrategy.IGNORE, entity = AlumnosList.class)
    void insertAlumnosLists(List<AlumnosListInsert> lists);*/

   /* @Query("SELECT id, nombre, apellidos, dni FROM alumnos_list")
    LiveData<List<AlumnosListForList>> getAll();

    @Query("SELECT id, nombre, apellidos,dni FROM alumnos_list WHERE category IN(:categories)")
    LiveData<List<AlumnosListForList>> getShoppingListsByCategories(List<String> categories);*/
    @Update
    void updateAlumnosList(AlumnosList alumnosList);

    @Update
    void updateAlumnosLists(List<AlumnosList> alumnosLists);

    @Delete
    void delete(AlumnosList a);

    //@Delete(entity = AlumnosList.class)
 //   public abstract void deleteAlumnosList(AlumnosListId id);

   // @Query("DELETE FROM alumnos_list WHERE id=:id")
   // void deleteShoppingList(String id);

}

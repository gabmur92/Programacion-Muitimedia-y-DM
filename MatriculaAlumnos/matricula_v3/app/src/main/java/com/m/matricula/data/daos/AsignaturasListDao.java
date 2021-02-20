package com.m.matricula.data.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import com.m.matricula.data.entities.AsignaturasList;

import java.util.List;
@Dao
public interface AsignaturasListDao {
    @Query("SELECT * FROM asignaturas_list")
    LiveData<List<AsignaturasList>> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(AsignaturasList asignaturasList);

}

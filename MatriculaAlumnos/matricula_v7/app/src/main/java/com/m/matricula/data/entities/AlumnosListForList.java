package com.m.matricula.data.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class AlumnosListForList {
    @PrimaryKey
    @ColumnInfo(name = "alumnos_list_id")
    public String id;

   public String nombre;

    public String apellidos;

    public String dni;

    public AlumnosListForList(String id) {
        this.id=id;
    }

}

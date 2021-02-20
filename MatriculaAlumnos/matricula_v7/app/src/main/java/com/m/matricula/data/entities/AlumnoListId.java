package com.m.matricula.data.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity
public class AlumnoListId {
    @ColumnInfo(name = "alumnos_list_id")
    public String id;

    public AlumnoListId(String id) {
        this.id = id;
    }
}

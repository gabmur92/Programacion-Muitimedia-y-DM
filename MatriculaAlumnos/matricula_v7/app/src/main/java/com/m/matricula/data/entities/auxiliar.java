package com.m.matricula.data.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName= "asignaturas_alumno")
public class auxiliar {

    @ColumnInfo(name = "alumnos_list_id")
    public final String idAlumnos;

    @ColumnInfo(name = "asignaturas_list_id")
    public final String idAsignaturas;

    public auxiliar(String idAlumnos, String idAsignaturas) {
        this.idAlumnos = idAlumnos;
        this.idAsignaturas = idAsignaturas;
    }
}

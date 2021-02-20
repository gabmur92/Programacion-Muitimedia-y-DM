package com.m.matricula.data.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName= "asignaturas_list")
public class AsignaturasList {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "asignaturas_list_id")
    public final String idAsignaturas;

    @NonNull
    @ColumnInfo(name="nombre_asignaturas")
    private final String nombreAsignaturas;

    @NonNull
    @ColumnInfo(name="numero_alumnos")
    private final String numeroAlumnos;

    public AsignaturasList(@NonNull String idAsignaturas, @NonNull String nombreAsignaturas, @NonNull String numeroAlumnos) {
        this.idAsignaturas = idAsignaturas;
        this.nombreAsignaturas = nombreAsignaturas;
        this.numeroAlumnos = numeroAlumnos;
    }

    public String getIdAsignaturas() {
        return idAsignaturas;
    }
    public String getNombreAsignaturas() {
        return nombreAsignaturas;
    }
    public String getNumeroAlumnos (){
        return numeroAlumnos;
    }

}

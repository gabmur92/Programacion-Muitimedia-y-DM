package com.m.matricula.data.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName= "asignaturas_list")
public class AsignaturasList {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name="id")
    private final String id;

    @NonNull
    @ColumnInfo(name="nombre")
    private final String nombre;

    public AsignaturasList(@NonNull String id, @NonNull String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
}

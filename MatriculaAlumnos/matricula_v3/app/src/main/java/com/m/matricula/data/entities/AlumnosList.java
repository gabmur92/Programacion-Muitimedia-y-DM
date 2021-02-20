package com.m.matricula.data.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName= "alumnos_list")
public class AlumnosList {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name="id")
    private final String id;

    @NonNull
    @ColumnInfo(name="nombre")
    private final String nombre;

    @NonNull
    @ColumnInfo(name="apellidos")
    private final String apellidos;

    @NonNull
    @ColumnInfo(name="dni")
    private final String dni;



    public AlumnosList(@NonNull String id, @NonNull String dni, @NonNull String nombre,@NonNull String apellidos) {
       this.id=id;
        this.dni = dni;
        this.nombre=nombre;
        this.apellidos=apellidos;
    }
    public String getId() {
        return id;
    }
    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }

}

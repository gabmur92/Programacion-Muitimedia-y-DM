package com.m.matricula.asignaturaAlumno;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.m.matricula.data.MatriculaListRepository;
import com.m.matricula.data.entities.AsignaturasList;

import java.util.List;

public class AsignaturaAlumnoViewModel {
    private final MatriculaListRepository mARepository;
    private final LiveData<List<AsignaturasAlumnoList>> mAsignaturasAlumno;


    public AsignaturaListViewModel(@NonNull Application application){
        super(application);
        mARepository=new MatriculaListRepository(application);
        mAsignaturasAlumno =mARepository.getAllAsignaturasLists();

    }
    public LiveData<List<AsignaturasList>> getAsignaturasLists(){
        return mAsignaturasAlumno;
    }
    public void insertAsignatura(AsignaturasList asignaturasList) {
        mARepository.insert(asignaturasList);
    }
}

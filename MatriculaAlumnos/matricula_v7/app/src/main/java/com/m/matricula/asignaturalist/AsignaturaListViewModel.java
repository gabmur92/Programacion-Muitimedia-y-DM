package com.m.matricula.asignaturalist;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;


import com.m.matricula.R;
import com.m.matricula.data.MatriculaListRepository;
import com.m.matricula.data.entities.AlumnosList;
import com.m.matricula.data.entities.AsignaturasList;

import java.util.List;


public class AsignaturaListViewModel extends AndroidViewModel {
    private final MatriculaListRepository mARepository;
    private final LiveData<List<AsignaturasList>> mAsignaturasLists;


    public AsignaturaListViewModel(@NonNull Application application){
        super(application);
        mARepository=new MatriculaListRepository(application);
        mAsignaturasLists =mARepository.getAllAsignaturasLists();

    }
    public LiveData<List<AsignaturasList>> getAsignaturasLists(){
        return mAsignaturasLists;
    }
    public void insertAsignatura(AsignaturasList asignaturasList) {
        mARepository.insert(asignaturasList);
    }

}
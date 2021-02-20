package com.m.matricula.asignaturalist;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.m.matricula.data.MatriculaListRepository;

import com.m.matricula.data.entities.AsignaturasList;

import java.util.List;

public class AsignaturasListViewModel extends AndroidViewModel {
    private final MatriculaListRepository mRepository;
    private final LiveData<List<AsignaturasList>> mAsignaturasLists;


    public AsignaturasListViewModel(@NonNull Application application){
        super(application);
        mRepository=new MatriculaListRepository(application);
        mAsignaturasLists =mRepository.getAllAsignaturasLists();

    }
    public LiveData<List<AsignaturasList>> getAsignaturasLists(){
        return mAsignaturasLists;
    }
    public void insert(AsignaturasList asignaturasList) {
        mRepository.insert(asignaturasList);
    }

}

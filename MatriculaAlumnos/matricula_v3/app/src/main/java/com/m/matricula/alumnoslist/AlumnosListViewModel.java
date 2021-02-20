package com.m.matricula.alumnoslist;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.m.matricula.data.MatriculaListRepository;
import com.m.matricula.data.entities.AlumnosList;
//import com.m.matricula.data.relationentities.AlumnoWhithColaborators;
//import com.m.matricula.partialentities.AlumnosListId;

import java.util.List;

public class AlumnosListViewModel extends AndroidViewModel {
    private final MatriculaListRepository mRepository;
    private final LiveData<List<AlumnosList>> mAlumnosLists;


    public AlumnosListViewModel(@NonNull Application application){
        super(application);
        mRepository=new MatriculaListRepository(application);
        mAlumnosLists =mRepository.getAllAlumnosLists();

    }
    public LiveData<List<AlumnosList>> getAlumnosLists(){
        return mAlumnosLists;
    }
    public void insert(AlumnosList alumnosList) {
        mRepository.insert(alumnosList);
    }

  /*  public void deleteAlumnosList(AlumnosList alumnosList) {
        AlumnosListId id = new AlumnosListId(alumnosList.getId());
        mRepository.deleteAlumnosList(id);
    }*/
}



package com.m.matricula.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.m.matricula.data.daos.AlumnosListDao;
import com.m.matricula.data.daos.AsignaturasListDao;
import com.m.matricula.data.entities.AlumnosList;
import com.m.matricula.data.entities.AsignaturasList;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {AlumnosList.class, AsignaturasList.class}, version = 2, exportSchema = false)
public abstract class MatriculaListDatabase extends RoomDatabase {
    public abstract AlumnosListDao alumnosListDao();
    public abstract AsignaturasListDao asignaturasListDao();

    private static final String DATABASE_NAME= "matricula-alumnos-db";

    private static MatriculaListDatabase INSTANCE;

    private static final int THREADS =4;

    public static final ExecutorService dbExecutor = Executors.newFixedThreadPool(THREADS);

    public static MatriculaListDatabase getInstance(final Context context){
        if (INSTANCE == null){
            synchronized (MatriculaListDatabase.class){
                if(INSTANCE ==null){
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(), MatriculaListDatabase.class,
                            DATABASE_NAME)
                            .addCallback(mRoomCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    private static final RoomDatabase.Callback mRoomCallback=new Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db){
            super.onCreate(db);

            dbExecutor.execute(() ->{
                AlumnosListDao dao= INSTANCE.alumnosListDao();
           //     List<AlumnosList> lists=new ArrayList<>();
             //   for (int i = 0; i < 5; i++) {
             //       String id = UUID.randomUUID().toString();
              //      lists.add(new AlumnosList("", "",""+ (i+1)));
               // }
              //  dao.insertAlumnosLists(lists);
                AsignaturasListDao adao= INSTANCE.asignaturasListDao();
                  AlumnosList alumno=new AlumnosList("1","44529350Q","Gabriel", "Martinez Murillo");
                 AlumnosList alumno2=new AlumnosList("2","445293","Gabri", "Martinez ");
                 AsignaturasList asignatura=new AsignaturasList("01","Interfaces");
                    dao.insert(alumno);
                    dao.insert(alumno2);
                 adao.insert(asignatura);
            });
        }

    };
}

package com.m.matricula.asignaturaAlumno;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.m.matricula.R;
import com.m.matricula.alumnoslist.AlumnosListAdapter;
import com.m.matricula.data.entities.AlumnosList;

import java.util.List;

public class AsignaturasAlumnoAdapter {
    private List<AsignaturasAlumno> mAlumnosList;


    @NonNull
    @Override
    public AsignaturasAlumnoListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        return AsignaturasAlumnoListViewHolder.create(parent);
         /*       LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.alumno_list_item,parent,false)
        );*/
    }
    @Override
    public void onBindViewHolder(@NonNull AsignaturasAlumnoListViewHolder holder, int position) {
        AsignaturasAlumno item = mAlumnosList.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return mAlumnosList == null ? 0 : mAlumnosList.size();
    }

    public void setItems(List<AsignaturasAlumno> items) {
        mAlumnosList = items;

    }
} public static class AsignaturasAlumnoListViewHolder extends RecyclerView.ViewHolder {
    private final TextView mNombreText;
    private final TextView mApellidosText;
    private final TextView mDniText;


    public AsignaturasAlumnoListViewHolder(@NonNull View itemView) {
        super(itemView);
        mNombreText = itemView.findViewById(R.id.nombre);
        mApellidosText = itemView.findViewById(R.id.apellidos);
        mDniText = itemView.findViewById(R.id.dni);

    }

    public void bind(AlumnosList item) {
        mNombreText.setText(item.getNombre());
        mApellidosText.setText(item.getApellidos());
        mDniText.setText(item.getDni());
    }

    public static AsignaturasAlumnoListViewHolder create(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.alumno_list_item, parent, false);
        return new AsignaturasAlumnoListViewHolder(v);
    }

}
}
package com.m.matricula.asignaturalist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.m.matricula.R;
import com.m.matricula.alumnoslist.AlumnosListAdapter;
import com.m.matricula.data.entities.AlumnosList;
import com.m.matricula.data.entities.AsignaturasList;

import java.util.List;

public class AsignaturaListAdapter extends RecyclerView.Adapter<AsignaturaListAdapter.AsignaturasListViewHolder>{
    private List<AsignaturasList> mAAsignaturasList;

    @NonNull
    @Override
    public AsignaturasListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        return  AsignaturasListViewHolder.create(parent);
            /*   LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.asignaturas_list_item,parent,false)
        );*/
    }
    @Override
    public void onBindViewHolder(@NonNull AsignaturasListViewHolder holder, int position) {
        AsignaturasList item = mAAsignaturasList.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return mAAsignaturasList == null ? 0 : mAAsignaturasList.size();
    }

    public void setItems(List<AsignaturasList> items) {
        mAAsignaturasList = items;
        //notifyDataSetChanged();
    }

    public static class AsignaturasListViewHolder extends RecyclerView.ViewHolder {
        private final TextView mNombreText;
        private final TextView mApellidosText;
        private final TextView mDniText;
        //  private final ImageView mDeleteButton;

        public AsignaturasListViewHolder(@NonNull View itemView) {
            super(itemView);
            mNombreText = itemView.findViewById(R.id.nombre);
            mApellidosText = itemView.findViewById(R.id.alumnos_inscritos);
            mDniText = itemView.findViewById(R.id.id);
            //     mDeleteButton = itemView.findViewById(R.id.delete_button);

            //     mDeleteButton.setOnClickListener(this::manageEvents);
        }
        /*   private void manageEvents(View view) {
               if (mItemListener != null) {
                   AlumnosList clickedItem = mAlumnosList.get(getAdapterPosition());

                 /  // Manejar evento de click en Favorito
                        if (view.getId() == R.id.delete_button) {
                       mItemListener.onDeleteIconClicked(clickedItem);
                       return;
                   }

                   mItemListener.onClick(clickedItem);
               }
           }*/
        public void bind(AsignaturasList item) {
            mNombreText.setText(item.getIdAsignaturas());
            mApellidosText.setText(item.getNombreAsignaturas());
            mDniText.setText(item.getNumeroAlumnos());
        }

        public static AsignaturasListViewHolder create(ViewGroup parent) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.asignaturas_list_item, parent, false);
            return new AsignaturasListViewHolder(v);
        }

    }
}


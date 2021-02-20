package com.m.matricula.asignaturalist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.m.matricula.R;
import com.m.matricula.data.entities.AsignaturasList;

import java.util.List;

public class AsignaturasListAdapter extends RecyclerView.Adapter<AsignaturasListAdapter.AsignaturasListViewHolder> {
    private List<AsignaturasList> mAsignaturasLists;

    @NonNull
    @Override
    public AsignaturasListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return  AsignaturasListViewHolder.create(parent);
          /*      LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.asignatura_list_item, parent, false)
        );*/
    }

    @Override
    public void onBindViewHolder(@NonNull AsignaturasListViewHolder holder, int position) {
        AsignaturasList item = mAsignaturasLists.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return mAsignaturasLists == null ? 0 : mAsignaturasLists.size();
    }

    public void setItems(List<AsignaturasList> items) {
        mAsignaturasLists = items;
        //   notifyDataSetChanged();
    }

    public static class AsignaturasListViewHolder extends RecyclerView.ViewHolder {
        private final TextView mAsignaturaText;
        private final TextView midText;

        public AsignaturasListViewHolder(@NonNull View itemView) {
            super(itemView);
            mAsignaturaText = itemView.findViewById(R.id.nombre_asignatura);
            midText = itemView.findViewById(R.id.id_asignatura);
        }

        public void bind(AsignaturasList item) {
            mAsignaturaText.setText(item.getNombre());
            midText.setText(item.getId());
        }

        public static AsignaturasListViewHolder create(ViewGroup parent) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.asignatura_list_item, parent, false);
            return new AsignaturasListViewHolder(v);
        }
    }
}

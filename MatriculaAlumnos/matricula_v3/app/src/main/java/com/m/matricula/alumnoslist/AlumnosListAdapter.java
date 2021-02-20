package com.m.matricula.alumnoslist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.m.matricula.R;
import com.m.matricula.data.entities.AlumnosList;
//import com.m.matricula.data.relationentities.AlumnoWhithColaborators;

import java.util.List;

public class AlumnosListAdapter extends RecyclerView.Adapter<AlumnosListAdapter.AlumnosListViewHolder>{
    private List<AlumnosList> mAlumnosList;
    //private List<AlumnosListForList> mAlumnosLists;
   // private ItemListener mItemListener;

    @NonNull
    @Override
    public AlumnosListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        return  AlumnosListViewHolder.create(parent);
          /*      LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.alumno_list_item,parent,false)
        );*/
    }
    @Override
    public void onBindViewHolder(@NonNull AlumnosListViewHolder holder, int position) {
        AlumnosList item = mAlumnosList.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return mAlumnosList == null ? 0 : mAlumnosList.size();
    }

    public void setItems(List<AlumnosList> items) {
        mAlumnosList = items;
        notifyDataSetChanged();
    }
   /* public void setItemListener(ItemListener listener) {
        mItemListener = listener;
    }
*/
    /*interface ItemListener {
        void onClick(AlumnosList alumnosList);

        //void onFavoriteIconClicked(ShoppingListWithCollaborators shoppingList);

        void onDeleteIconClicked(AlumnosList alumnoList);

        void onDeleteIconClicked(AlumnoWhithColaborators alumnosList);
    }*/
    public static class AlumnosListViewHolder extends RecyclerView.ViewHolder {
        private final TextView mNombreText;
        private final TextView mApellidosText;
        private final TextView mDniText;
     //   private final ImageView mDeleteButton;

        public AlumnosListViewHolder(@NonNull View itemView) {
            super(itemView);
            mNombreText = itemView.findViewById(R.id.nombre);
            mApellidosText = itemView.findViewById(R.id.apellidos);
            mDniText = itemView.findViewById(R.id.dni);
         //   mDeleteButton = itemView.findViewById(R.id.delete_button);

         //   mDeleteButton.setOnClickListener(this::manageEvents);
        }
    /*    private void manageEvents(View view) {
            if (mItemListener != null) {
                AlumnosList clickedItem = mAlumnosList.get(getAdapterPosition());

                // Manejar evento de click en Favorito
                     if (view.getId() == R.id.delete_button) {
                    mItemListener.onDeleteIconClicked(clickedItem);
                    return;
                }

                mItemListener.onClick(clickedItem);
            }*/
       // }
        public void bind(AlumnosList item) {
            mNombreText.setText(item.getNombre());
            mApellidosText.setText(item.getApellidos());
            mDniText.setText(item.getDni());
        }

        public static AlumnosListViewHolder create(ViewGroup parent) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.alumno_list_item, parent, false);
            return new AlumnosListViewHolder(v);
        }
    }
}

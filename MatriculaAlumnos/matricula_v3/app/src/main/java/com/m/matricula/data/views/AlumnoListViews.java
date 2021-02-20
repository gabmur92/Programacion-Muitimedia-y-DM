package com.m.matricula.data.views;

import androidx.room.ColumnInfo;
import androidx.room.DatabaseView;

@DatabaseView(
        value = "SELECT l.*, i.created_date, COUNT(*) as itemsCount " +
                "FROM shopping_list l " +
                "INNER JOIN info i " +
                "USING(shopping_list_id) " +
                "INNER JOIN shopping_list_item " +
                "USING(shopping_list_id) " +
                "INNER JOIN item " +
                "USING(item_id)" +
                "GROUP BY l.shopping_list_id",
        viewName = "v_full_shopping_lists"
)
public class AlumnoListViews {
    @ColumnInfo(name = "alumnos_list_id")
    public String id;

    public String nombre;

    public String category;

}

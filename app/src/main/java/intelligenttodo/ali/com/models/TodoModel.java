package intelligenttodo.ali.com.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import intelligenttodo.ali.com.data.Todo;
import intelligenttodo.ali.com.helpers.DbHelper;
import static nl.qbusict.cupboard.CupboardFactory.cupboard;


public class TodoModel {
    SQLiteDatabase db;

    public TodoModel(Context context) {
        db = DbHelper.getIsntance(context).getWritableDatabase();
    }

    public boolean insert(Todo todo) {
        try {
            cupboard().withDatabase(db).put(todo);
        } catch (Exception e) {
            //no code
        }
        return true;
    }

    public List<Todo> select()
    {
        return cupboard().withDatabase(db).query(Todo.class).list();
    }


}

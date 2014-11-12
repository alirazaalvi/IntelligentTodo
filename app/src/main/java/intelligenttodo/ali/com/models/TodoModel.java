package intelligenttodo.ali.com.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import intelligenttodo.ali.com.data.Todo;
import intelligenttodo.ali.com.helpers.DbHelper;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;


public class TodoModel {
    private final SQLiteDatabase db;

    public TodoModel(Context context) {
        db = DbHelper.getIsntance(context).getWritableDatabase();
    }

    public long insert(Todo todo) {
        return cupboard().withDatabase(db).put(todo);
    }

    public List<Todo> select() {
        return cupboard().withDatabase(db).query(Todo.class).list();
    }


}

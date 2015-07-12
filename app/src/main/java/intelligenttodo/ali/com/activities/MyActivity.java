package intelligenttodo.ali.com.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;

import com.yahoo.squidb.data.DatabaseDao;
import com.yahoo.squidb.data.SquidCursor;
import com.yahoo.squidb.sql.Query;

import java.util.ArrayList;
import java.util.List;

import intelligenttodo.ali.com.R;
import intelligenttodo.ali.com.adapters.ListMainAdapter;
import intelligenttodo.ali.com.data.Todo;
import intelligenttodo.ali.com.helpers.SquidbHelper;


public class MyActivity extends ActionBarActivity {

    private List<Todo> todoItems = new ArrayList<Todo>();
    private DatabaseDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dao = new DatabaseDao(new SquidbHelper(this));

        Query allTodos = Query.select(Todo.PROPERTIES);
        SquidCursor<Todo> todos = dao.query(Todo.class, allTodos);

        try {
            for (todos.moveToFirst(); !todos.isAfterLast(); todos.moveToNext()) {
                Todo t = new Todo();
                t.readPropertiesFromCursor(todos);
                todoItems.add(t);
            }
        } finally {
            todos.close();
        }


        RecyclerView rvTodoList = (RecyclerView) findViewById(R.id.rv_main_list);
        rvTodoList.setLayoutManager(new LinearLayoutManager(this));
        rvTodoList.setItemAnimator(new DefaultItemAnimator());

        final ListMainAdapter listMainAdapter = new ListMainAdapter(todoItems, R.layout.list_main_item, this);
        rvTodoList.setAdapter(listMainAdapter);

        final EditText editTextQuickTodo = (EditText) findViewById(R.id.et_quick_todo);

        ImageView imgAddTodo = (ImageView) findViewById(R.id.img_add_quick_todo);
        imgAddTodo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Todo todo = new Todo();
                todo.setTitle(editTextQuickTodo.getText().toString());
                //todo.setDateAdded(new DateTime().toString());
                dao.persist(todo);
                todoItems.add(todo);
                listMainAdapter.notifyItemInserted(todoItems.size());
            }
        });


    }

}

package intelligenttodo.ali.com.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.Menu;
import intelligenttodo.ali.com.R;
import intelligenttodo.ali.com.adapters.ListMainAdapter;
import intelligenttodo.ali.com.models.TodoModel;


public class MyActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        TodoModel todoModel = new TodoModel(this);

        RecyclerView rvTodoList = (RecyclerView) findViewById(R.id.rv_main_list);
        rvTodoList.setLayoutManager(new LinearLayoutManager(this));
        rvTodoList.setItemAnimator(new DefaultItemAnimator());

        ListMainAdapter listMainAdapter = new ListMainAdapter(todoModel.select(), R.layout.list_main_item, this);
        rvTodoList.setAdapter(listMainAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

}

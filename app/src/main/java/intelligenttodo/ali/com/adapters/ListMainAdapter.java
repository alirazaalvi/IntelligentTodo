package intelligenttodo.ali.com.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import intelligenttodo.ali.com.R;
import intelligenttodo.ali.com.data.Todo;

public class ListMainAdapter extends RecyclerView.Adapter<ListMainAdapter.ListHolder> {

    private List<Todo> mListTodo;
    private int mRowLayout;
    private Context mContext;

    public ListMainAdapter(List<Todo> listTodo, int resource, Context context) {
        mListTodo = listTodo;
        mRowLayout = resource;
        mContext = context;
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(mRowLayout, viewGroup, false);
        return new ListHolder(v);
    }

    @Override
    public void onBindViewHolder(ListHolder listHolder, int i) {
        Todo todo = mListTodo.get(i);
        listHolder.txtTitle.setText(todo.getTitle());
    }

    @Override
    public int getItemCount() {
        return mListTodo == null ? 0 : mListTodo.size();
    }

    public static class ListHolder extends RecyclerView.ViewHolder {
        TextView txtTitle;

        public ListHolder(View itemView) {
            super(itemView);
            txtTitle = (TextView) itemView.findViewById(R.id.txt_main_list_title);
        }
    }
}

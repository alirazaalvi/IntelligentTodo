package intelligenttodo.ali.com.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.yahoo.squidb.data.AbstractDatabase;
import com.yahoo.squidb.sql.Table;

import intelligenttodo.ali.com.data.Todo;

/**
 * Created by Ali on 7/11/2015.
 */
public class SquidbHelper extends AbstractDatabase {
    private static final int VERSION = 1;
    private static final String NAME = "todoDb.db";

    public SquidbHelper(Context context) {
        super(context);
    }

    @Override
    protected String getName() {
        return NAME;
    }


    @Override
    protected Table[] getTables() {
        return new Table[]{
                // List all tables here
                Todo.TABLE,
        };
    }

    @Override
    protected int getVersion() {
        return VERSION;
    }

    @Override
    protected boolean onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*switch(oldVersion) {
            case 1:
        }*/
        return true;
    }
}

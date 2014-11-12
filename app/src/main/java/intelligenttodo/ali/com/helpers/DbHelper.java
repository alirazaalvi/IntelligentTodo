package intelligenttodo.ali.com.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import intelligenttodo.ali.com.data.Todo;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class DbHelper extends SQLiteOpenHelper {
    private static final int mDbVersion = 1;
    private static DbHelper mInstance = null;
    private static final Object mutex = new Object();

    private DbHelper(Context context) {
        super(context, "Todo", null, mDbVersion);
    }

    static {
        cupboard().register(Todo.class);
    }

    public static DbHelper getIsntance(Context context) {
        if (mInstance == null) {
            synchronized (mutex) {
                mInstance = new DbHelper(context);
            }
        }
        return mInstance;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        cupboard().withDatabase(db).createTables();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i2) {
        cupboard().withDatabase(db).upgradeTables();
    }
}

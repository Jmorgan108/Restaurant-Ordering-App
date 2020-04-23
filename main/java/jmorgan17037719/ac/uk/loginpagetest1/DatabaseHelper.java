package jmorgan17037719.ac.uk.loginpagetest1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "register.db";
    public static final String TABLE_NAME = "registeruser";
    public static final String COL1 = "ID";
    public static final String COL2 = "username";
    public static final String COL3 = "password";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase Database) {
        Database.execSQL("CREATE TABLE registeruser (ID INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase Database, int i, int i1) {
        Database.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(Database);
    }

    public long addUser(String user, String password) {
        SQLiteDatabase DataB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", user);
        contentValues.put("password", password);
        long res = DataB.insert("registeruser", null,contentValues);
        DataB.close();
        return res;
    }

    public boolean checkUser(String username, String password) {
        String[] columns = { COL1 };
        SQLiteDatabase DataB = getReadableDatabase();
        String selection = COL2 + "=?" + " and " + COL3 + "=?";
        String[] selectionArgs = { username, password };
        Cursor cursor = DataB.query(TABLE_NAME,columns,selection,selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        DataB.close();

        if(count>0)
            return true;
        else
            return false;
    }

}


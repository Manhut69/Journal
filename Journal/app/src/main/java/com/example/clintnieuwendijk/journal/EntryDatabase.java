package com.example.clintnieuwendijk.journal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class EntryDatabase extends SQLiteOpenHelper {

    private static EntryDatabase instance;

    public EntryDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    public static EntryDatabase getInstance(Context context) {
        if (instance == null) {
            instance = new EntryDatabase(context, "entries", null, 42);
        }
        return instance;
    }

    public Cursor selectAll() {
        SQLiteDatabase db = getWritableDatabase();
        return db.rawQuery("SELECT * FROM 'entries';", null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE 'entries' ('_id' integer PRIMARY KEY AUTOINCREMENT NOT NULL, 'title' text, 'content' text, 'mood' text, 'timestamp' text DEFAULT CURRENT_TIMESTAMP);");
        db.execSQL("INSERT INTO 'entries' ('_id','title','content','mood') VALUES (NULL,'Feeling angery!','Neighbors nagged about jellyfishing','angry');");
        db.execSQL("INSERT INTO 'entries' ('_id','title','content','mood') VALUES (NULL,'Glad!','Neighbors went on vacation','glad');");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE 'entries'");
        onCreate(db);
    }

    public void insert(JournalEntry je) {
        SQLiteDatabase db = getWritableDatabase();
        Log.d(je.getTitle(), je.getContent());
        db.execSQL(String.format("INSERT INTO 'entries' ('title', 'content', 'mood') VALUES (\"%s\", \"%s\", '%s')", je.getTitle().replace("\"", "\'"), je.getContent().replace("\"", "\'"), je.getMood()));
    }

    public void delete(long id) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = String.format("DELETE FROM 'entries' WHERE (rowid = %d)", id);
        Log.d("sql", sql);
        db.execSQL(sql);

    }

    Cursor selectByID(long rowIndex) {
        SQLiteDatabase db = getWritableDatabase();
        String[] queryIds = new String[1];
        queryIds[0] = Long.toString(rowIndex);
        String sql = String.format("SELECT * FROM 'entries' WHERE (rowid = %d)", rowIndex);
        return db.rawQuery(sql, null);
    }
}

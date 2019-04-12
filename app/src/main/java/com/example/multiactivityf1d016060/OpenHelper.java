package com.example.multiactivityf1d016060;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class OpenHelper extends SQLiteOpenHelper {
    static final String DB_NAME = "DotaDB";
    static final Integer DB_VERSION = 1;

    public OpenHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREAte TABLE Siswa ("+
                "nim TEXT PRIMARY KEY,"+
                " nama TEXT, nilai TEXT");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("Upgrade", "Proses akan drop dan buat ulang tabel.");
        db.execSQL("DROP TABLE IF EXIST Siswa");
        onCreate(db);
    }
}


package com.randy.wisatasemarang.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "dbwisata";
    private final static String DATABASE_TABLE = "table_wisata";
    private final static String WISATA_ID = "_id";
    private final static String NAMA_WISATA = "nama_wisata";
    private final static String GAMBAR_WISATA = "gambar_wisata";
    private final static String ALAMAT_WISATA = "alamat_wisata";
    private final static String DESKRIPSI_WISATA = "deskripsi_wisata";
    private final static String LATITUDE_WISATA = "latitude_wisata";
    private final static String LONGITUDE_WISATA = "longitude_wisata";

    private final static int DATABASE_VERSION = 1;

    private final static String CREATE_TABLE = "CREATE TABLE " + DATABASE_TABLE + " (" + WISATA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAMA_WISATA + " VARCHAR(200), "
            + GAMBAR_WISATA + " VARCHAR(200), "
            + ALAMAT_WISATA + " TEXT, "
            + DESKRIPSI_WISATA + " TEXT, "
            + LATITUDE_WISATA + " VARCHAR(20), "
            + LONGITUDE_WISATA + " VARCHAR(20));";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(db);
    }

    public long insertData(String namaWisata,
                           String gambarWisata,
                           String alamatWisata,
                           String deskripsiWisata,
                           String latWisata,
                           String longWisata) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAMA_WISATA, namaWisata);
        contentValues.put(GAMBAR_WISATA, gambarWisata);
        contentValues.put(ALAMAT_WISATA, alamatWisata);
        contentValues.put(DESKRIPSI_WISATA, deskripsiWisata);
        contentValues.put(LATITUDE_WISATA, latWisata);
        contentValues.put(LONGITUDE_WISATA, longWisata);
        long id = db.insert(DATABASE_TABLE, null, contentValues);
        db.close();
        return id;
    }
}

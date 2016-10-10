package com.bagicode.www.videocrudsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bagicode on 28/09/16.
 */

public class DatabaseHandler extends SQLiteOpenHelper{

    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_kampus";

    private static final String tb_mahasiswa = "tb_mahasiswa";

    private static final String tb_mhsiswa_id = "id";
    private static final String tb_mhsiswa_nama = "nama";
    private static final String tb_mhsiswa_kelas = "akun";

    private static final String CREATE_TABLE_MAHASISWA = "CREATE TABLE " + tb_mahasiswa + "("
            + tb_mhsiswa_id + " INTEGER PRIMARY KEY ,"
            + tb_mhsiswa_nama + " TEXT,"
            + tb_mhsiswa_kelas + " TEXT " + ")";

    public DatabaseHandler (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MAHASISWA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateMahasiswa (ModalMahasiswa mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_mhsiswa_id, mdNotif.get_id());
        values.put(tb_mhsiswa_nama, mdNotif.get_nama());
        values.put(tb_mhsiswa_kelas, mdNotif.get_kelas());
        db.insert(tb_mahasiswa, null, values);
        db.close();
    }

    public List<ModalMahasiswa> ReadMahasiswa() {
        List<ModalMahasiswa> judulModelList = new ArrayList<ModalMahasiswa>();
        String selectQuery = "SELECT  * FROM " + tb_mahasiswa;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ModalMahasiswa mdKontak = new ModalMahasiswa();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_nama(cursor.getString(1));
                mdKontak.set_kelas(cursor.getString(2));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }

    public int UpdateMahasiswa (ModalMahasiswa mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(tb_mhsiswa_nama, mdNotif.get_nama());
        values.put(tb_mhsiswa_kelas, mdNotif.get_kelas());

        return db.update(tb_mahasiswa, values, tb_mhsiswa_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }

    public void DeleteMahasiswa (ModalMahasiswa mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_mahasiswa, tb_mhsiswa_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}

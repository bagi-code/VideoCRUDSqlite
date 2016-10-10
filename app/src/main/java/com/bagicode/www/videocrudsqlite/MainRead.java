package com.bagicode.www.videocrudsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private DatabaseHandler db;
    private List<ModalMahasiswa> ListMahasiswa = new ArrayList<ModalMahasiswa>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        db = new DatabaseHandler(this);

        adapter_off = new CustomListAdapter(this, ListMahasiswa );
        mListView = (ListView) findViewById(R.id.list_mahasiswa);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListMahasiswa.clear();

        List<ModalMahasiswa> contacts = db.ReadMahasiswa();
        for (ModalMahasiswa cn : contacts) {
            ModalMahasiswa judulModel = new ModalMahasiswa();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_kelas(cn.get_kelas());
            ListMahasiswa.add(judulModel);

            if ((ListMahasiswa.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        ModalMahasiswa obj_itemDetails = (ModalMahasiswa)o;

        String Sid = obj_itemDetails.get_id();
        String Snama = obj_itemDetails.get_nama();
        String Skelas = obj_itemDetails.get_kelas();

        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Ikelas", Skelas);
        startActivity(goUpdel);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListMahasiswa.clear();
        mListView.setAdapter(adapter_off);

        List<ModalMahasiswa> contacts = db.ReadMahasiswa();
        for (ModalMahasiswa cn : contacts) {
            ModalMahasiswa judulModel = new ModalMahasiswa();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_kelas(cn.get_kelas());
            ListMahasiswa.add(judulModel);

            if ((ListMahasiswa.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }

    }
}

package com.bagicode.www.videocrudsqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainCreate extends AppCompatActivity {
    private DatabaseHandler db;
    private EditText Enama, Ekelas;
    private String Snama, Skelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        db = new DatabaseHandler(this);

        Enama = (EditText) findViewById(R.id.create_nama) ;
        Ekelas = (EditText) findViewById(R.id.create_kelas);

        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snama = String.valueOf(Enama.getText());
                Skelas = String.valueOf(Ekelas.getText());

                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama", Toast.LENGTH_SHORT).show();
                } else if (Skelas.equals("")){
                    Ekelas.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi kelas", Toast.LENGTH_SHORT).show();
                } else {
                    Enama.setText("");
                    Ekelas.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah", Toast.LENGTH_SHORT).show();
                    db.CreateMahasiswa(new ModalMahasiswa(null, Snama, Skelas));
                }

            }
        });
    }


}

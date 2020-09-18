package com.example.realmdatabase;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {
    Button btnSimpan, btnTampil;
    EditText nim, nama;
    String sNama;
    Integer sNim;
    Realm realm;
    RealmHelper realmHelper;
    MahasiswaModel mahasiswaModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSimpan = findViewById(R.id.btnSimpan);
        btnTampil = findViewById(R.id.btnTampil);
        nim = findViewById(R.id.nim);
        nama = findViewById(R.id.nama);

        //Set up Realm
        Realm.init(MainActivity.this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);


        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!nim.getText().toString().isEmpty() && !nama.getText().toString().isEmpty()){
                    sNim = Integer.parseInt(nim.getText().toString());
                    sNama = nama.getText().toString();
                    if (!sNim.equals("") && !sNama.isEmpty()){
                        mahasiswaModel = new MahasiswaModel();
                        mahasiswaModel.setNim(sNim);
                        mahasiswaModel.setNama(sNama);

                        realmHelper = new RealmHelper(realm);
                        realmHelper.save(mahasiswaModel);

                        Toast.makeText(MainActivity.this, "Berhasil Disimpan!", Toast.LENGTH_SHORT).show();

                        nim.setText("");
                        nama.setText("");
                    }else {

                    }
                }else {
                    Toast.makeText(MainActivity.this, "data belum diisi", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnTampil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MahasiswaActivity.class));

            }
        });
    }

}
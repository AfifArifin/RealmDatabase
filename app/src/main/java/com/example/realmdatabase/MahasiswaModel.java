package com.example.realmdatabase;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class MahasiswaModel extends RealmObject {

    @PrimaryKey
    private int id;
    private int nim;
    private String nama;

    public void setId(Integer id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNim(Integer nim) {
        this.nim = nim;
    }

    public int getNim() {
        return nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }
}

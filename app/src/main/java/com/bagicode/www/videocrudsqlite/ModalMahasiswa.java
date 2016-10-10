package com.bagicode.www.videocrudsqlite;

/**
 * Created by bagicode on 28/09/16.
 */

public class ModalMahasiswa {

    private String _id, _nama, _kelas;

    public ModalMahasiswa (String id, String nama, String kelas) {
        this._id = id;
        this._nama = nama;
        this._kelas = kelas;
    }

    public ModalMahasiswa () {

    }

    public void set_id (String id) {
        this._id = id;
    }

    public String get_id () {
        return this._id;
    }

    public void set_nama (String nama) {
        this._nama = nama;
    }

    public String get_nama () {
        return this._nama;
    }

    public void set_kelas (String kelas) {
        this._kelas = kelas;
    }

    public String get_kelas () {
        return this._kelas;
    }

}

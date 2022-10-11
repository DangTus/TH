package com.dmt.dangtus.learnandroid.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dmt.dangtus.learnandroid.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienDao {
    private SQLiteDatabase db;

    public SinhVienDao(Context context) {
        DBHelper dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    @SuppressLint("Range")
    public List<SinhVien> get(String sql, String ...doiSo) {
        List<SinhVien> sinhVienList = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, doiSo);

        while (cursor.moveToNext()) {
            SinhVien sinhVien = new SinhVien();
            sinhVien.setId(cursor.getString(cursor.getColumnIndex("id")));
            sinhVien.setName(cursor.getString(cursor.getColumnIndex("name")));
            sinhVien.setScore(cursor.getDouble(cursor.getColumnIndex("score")));
            sinhVienList.add(sinhVien);
        }

        return sinhVienList;
    }

    public List<SinhVien> getAll() {
        String sql = "SELECT * FROM SinhVien";

        return get(sql);
    }

    public SinhVien getById(String id) {
        String sql = "SELECT * FROM SinhVien WHERE id = ?";
        List<SinhVien> sinhVienList = get(sql, id);

        return sinhVienList.get(0);
    }

    public long insert(SinhVien sinhVien) {
        ContentValues values = new ContentValues();
        values.put("id", sinhVien.getId());
        values.put("name", sinhVien.getName());
        values.put("score", sinhVien.getScore());

        return db.insert("SinhVien", null, values);
    }

    public long update(SinhVien sinhVien) {
        ContentValues values = new ContentValues();
        values.put("name", sinhVien.getName());
        values.put("score", sinhVien.getScore());

        return db.update("SinhVien", values, "id = ?", new String[]{sinhVien.getId()});
    }

    public long delete(String id) {
        return db.delete("SinhVien", "id = ?", new String[]{id});
    }
}

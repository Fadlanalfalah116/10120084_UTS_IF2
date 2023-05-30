//Nim:10120084
//Nama:Fadlan Alfalah Baihaaqi
//Kelas:IF2

package com.example.splashscreenanimation;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.Toast;

public class DatabasePresenterImpl extends DatabasePresenter {
    private SQLiteDatabase database;
    private Context context;

    public DatabasePresenterImpl(Context context) {
        // Memanggil konstruktor superclass tanpa argumen
        super();
        // Membuka koneksi ke database
        this.context = context.getApplicationContext();
        DatabaseHelper dbHelper = new DatabaseHelper(this.context);
        database = dbHelper.getWritableDatabase();
    }

    @Override
    public void saveNoteToDatabase(String date, String title, String category, String content) {
        // Memasukkan data ke dalam database
        try {
            ContentValues values = new ContentValues();
            values.put("date", date);
            values.put("title", title);
            values.put("category", category);
            values.put("content", content);

            long newRowId = database.insert("notes", null, values);

            if (newRowId != -1) {
                // Data berhasil disimpan
                Toast.makeText(context, "Catatan disimpan", Toast.LENGTH_SHORT).show();
            } else {
                // Gagal menyimpan data
                Toast.makeText(context, "Gagal menyimpan catatan", Toast.LENGTH_SHORT).show();
            }
        } catch (SQLiteException e) {
            Toast.makeText(context, "Gagal menyimpan catatan", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}

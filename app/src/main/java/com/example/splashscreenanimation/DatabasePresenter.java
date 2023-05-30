//Nim:10120084
//Nama:Fadlan Alfalah Baihaaqi
//Kelas:IF2

package com.example.splashscreenanimation;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.example.splashscreenanimation.DatabaseHelper;

public class DatabasePresenter {
    private SQLiteDatabase database;

    public DatabasePresenter() {
        // Membuka koneksi ke database
        Context context;
        DatabaseHelper dbHelper = new DatabaseHelper(getActivity());
        database = dbHelper.getWritableDatabase();
    }

    public DatabasePresenter(FragmentActivity activity) {
    }

    public void saveNoteToDatabase(String date, String title, String category, String content) {
        // Memasukkan data ke dalam database
        try {
            ContentValues values = new ContentValues();
            values.put(DatabaseHelper.COLUMN_DATE, date);
            values.put(DatabaseHelper.COLUMN_TITLE, title);
            values.put(DatabaseHelper.COLUMN_CATEGORY, category);
            values.put(DatabaseHelper.COLUMN_CONTENT, content);

            long newRowId = database.insert(DatabaseHelper.TABLE_NAME, null, values);

            if (newRowId != -1) {
                // Data berhasil disimpan
                Toast.makeText(getActivity(), "Catatan disimpan", Toast.LENGTH_SHORT).show();
            } else {
                // Gagal menyimpan data
                Toast.makeText(getActivity(), "Gagal menyimpan catatan", Toast.LENGTH_SHORT).show();
            }
        } catch (SQLiteException e) {
            Toast.makeText(getActivity(), "Gagal menyimpan catatan", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private Context getActivity() {
        // Mengembalikan konteks yang sesuai
        // (misalnya, bisa menggunakan konteks aplikasi atau aktivitas yang saat ini sedang berjalan)
        return null;
    }
}


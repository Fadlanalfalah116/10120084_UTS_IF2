//Nim:10120084
//Nama:Fadlan Alfalah Baihaaqi
//Kelas:IF2

package com.example.splashscreenanimation;

import android.content.Context;

import java.util.List;

public class NotePresenter {
    private DatabaseHelper databaseHelper;

    public NotePresenter(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public void saveNoteToDatabase(Note note) {
        databaseHelper.insertNote(note);
    }

    public List<Note> getAllNotes() {
        return databaseHelper.getAllNotes();
    }
}

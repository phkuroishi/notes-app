package com.phk.notes.repository;

import com.phk.notes.entity.Note;

import java.util.ArrayList;

public class NoteRepository {

    private static ArrayList<Note> notes;

    static {
        notes = new ArrayList<>();

        for(int i = 1; i <= 20; i++) {
            notes.add(new Note(
                    "Nota " + i, String.valueOf(i)
            ));
        }
    }

    public static void insert(Note note) {
        notes.add(note);
    }


    public static ArrayList<Note> findAll() {
        return notes;
    }
}

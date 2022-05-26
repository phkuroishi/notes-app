package com.phk.notes.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.phk.notes.R;
import com.phk.notes.entity.Note;
import com.phk.notes.repository.NoteRepository;
import com.phk.notes.ui.recyclerview.adapter.MainAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private RecyclerView noteList;
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupRecycler();

        setupFab();
    }


    private void setupFab() {
        fab = findViewById(R.id.fab_add_item);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewNoteActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setupRecycler() {

        List<Note> items = NoteRepository.findAll();
        adapter = new MainAdapter(this, items);
        noteList = findViewById(R.id.recyclerView);
        noteList.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        noteList.setAdapter(adapter);
    }
}
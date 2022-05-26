package com.phk.notes.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.phk.notes.R;
import com.phk.notes.entity.Note;
import com.phk.notes.repository.NoteRepository;

public class NewNoteActivity extends AppCompatActivity {

    private EditText newTitle, newDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        newTitle = findViewById(R.id.title_edittext);
        newDescription = findViewById(R.id.description_edittext);


        findViewById(R.id.save_button_new_note).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String nTitle = newTitle.getText().toString().trim();
                String nDescription = newDescription.getText().toString().trim();

                if(nTitle.isEmpty() ) {
                    newTitle.setError("Adicione um título");
                    newTitle.requestFocus();
                    return;
                } else if (nDescription.isEmpty()){
                    newDescription.setError("Adicione uma descrição");
                    newDescription.requestFocus();
                    return;
                }

                NoteRepository.insert(new Note(nTitle, nDescription));
                finish();
            }
        });
    }
}
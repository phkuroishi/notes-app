package com.phk.notes.ui.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.phk.notes.R;
import com.phk.notes.entity.Note;
import com.phk.notes.repository.NoteRepository;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private List<Note> notes;
    private Context context;


    public MainAdapter(Context context, List<Note> notes) {
        this.context = context;
        this.notes = notes;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_nota, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        Note n = notes.get(position);

        TextView title = holder.itemView.findViewById(R.id.title_textview);
        TextView description = holder.itemView.findViewById(R.id.description_textview);
        holder.itemView.findViewById(R.id.delete_button).setOnClickListener(view ->
                delete(position));

        title.setText(n.getTitle());
        description.setText(n.getDescription());
    }

    private void delete(int position) {
        notes.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, notes.size());
    }


    @Override
    public int getItemCount() {
        return notes.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder{
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

package com.example.notespro;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import org.w3c.dom.Text;

public class NoteAdapter extends FirestoreRecyclerAdapter<Note,NoteAdapter.NoteViewHolder>{
Context context;

    public NoteAdapter(FirestoreRecyclerOptions<Note> options, Context context){
        super(options);
        this.context=context;
    }
    @Override
    protected void onBindViewHolder(@NonNull NoteViewHolder holder, int position, @NonNull Note note) {
          holder.titleTextView.setText(note.title);
        holder.contentTextView.setText(note.title);
        holder.timestampTextView.setText(Utility.timestampToString(note.timestamp));

        holder.itemView.setOnClickListener((v)->{
            Intent intent = new Intent(context,NoteDetailsActivity.class);
            intent.putExtra("title",note.title);
            intent.putExtra("content",note.content);
            String docId = this.getSnapshots().getSnapshot(position).getId();
            intent.putExtra("docId",note.title);
            context.startActivity(intent);
        });

    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_note_item,parent,false);
        return new NoteViewHolder(view);
    }

    class NoteViewHolder extends RecyclerView.ViewHolder{
        TextView titleTextView,contentTextView,timestampTextView;;

        public NoteViewHolder(View itemView){
            super(itemView);
            titleTextView = itemView.findViewById(R.id.notes_title_text_view);
            contentTextView = itemView.findViewById(R.id.notes_content_text_view);
            titleTextView = itemView.findViewById(R.id.notes_timestamp_text_view);

        }
    }
}

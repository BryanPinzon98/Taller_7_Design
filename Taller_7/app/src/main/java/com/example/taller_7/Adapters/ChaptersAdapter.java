package com.example.taller_7.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.taller_7.Activities.ChapterDetailActivity;
import com.example.taller_7.Entities.Chapter;
import com.example.taller_7.R;


import java.util.List;


public class ChaptersAdapter extends RecyclerView.Adapter<ChaptersAdapter.MyViewHolder> {

    private Context context;
    private List<Chapter> chaptersList;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView chapterTitle, chapterName, chapterDuration;
        private View view;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.chapterTitle = itemView.findViewById(R.id.chapter_title);
            this.chapterName = itemView.findViewById(R.id.chapter_name);
            this.chapterDuration = itemView.findViewById(R.id.chapter_duration);
            this.view = itemView;
        }
    }

    public ChaptersAdapter(Context context) {
        this.context = context;
        this.chaptersList = Chapter.prepareChapters(
                context.getResources().getStringArray(R.array.chaptersTitles),
                context.getResources().getStringArray(R.array.chaptersNames),
                context.getResources().getStringArray(R.array.chaptersDurations)
        );
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chapter_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Chapter chapter = chaptersList.get(position);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, ChapterDetailActivity.class);
                context.startActivity(intent);

            }
        });

        holder.chapterTitle.setText(chapter.getChapterTitle());
        holder.chapterName.setText(chapter.getChapterName());
        holder.chapterDuration.setText(chapter.getChapterDuration());
    }

    @Override
    public int getItemCount() {
        return chaptersList.size();
    }
}

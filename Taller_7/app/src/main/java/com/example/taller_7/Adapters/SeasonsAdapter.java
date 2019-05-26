package com.example.taller_7.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.taller_7.Entities.Season;
import com.example.taller_7.Fragments.ChaptersFragment;
import com.example.taller_7.R;


import java.util.List;


public class SeasonsAdapter extends RecyclerView.Adapter<SeasonsAdapter.MyViewHolder> {

    private Context context;
    private List<Season> seasonsList;


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView seasonImage;
        public TextView seasonName;
        private View view;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.seasonImage = itemView.findViewById(R.id.season_image);
            this.seasonName = itemView.findViewById(R.id.season_name);
            this.view = itemView;
        }
    }

    public SeasonsAdapter(Context context, int seasonsQuantity) {
        this.context = context;
        this.seasonsList = Season.prepareSeasons(
                context.getResources().obtainTypedArray(R.array.seasonsImages),
                context.getResources().getStringArray(R.array.seasonsNames),
                seasonsQuantity
        );
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.seasons_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Season season = seasonsList.get(position);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fm = ((AppCompatActivity) context).getSupportFragmentManager();

                if (context.getResources().getBoolean(R.bool.has_two_panes)) {
                    fm.beginTransaction().replace(R.id.seasons_fragment, new ChaptersFragment()).commit();
                } else {
                    fm.beginTransaction().replace(R.id.series_list, new ChaptersFragment()).addToBackStack(null).commit();
                }
            }
        });

        Glide.with(context).load(season.getSeasonImage()).into(holder.seasonImage);
        holder.seasonName.setText(season.getSeasonName());
    }

    @Override
    public int getItemCount() {
        return seasonsList.size();
    }
}

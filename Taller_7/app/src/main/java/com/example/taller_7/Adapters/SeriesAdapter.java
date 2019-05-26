package com.example.taller_7.Adapters;

import android.content.Context;
import android.os.Bundle;
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
import com.example.taller_7.Entities.Serie;
import com.example.taller_7.Fragments.SeasonsFragment;
import com.example.taller_7.R;


import java.util.List;


public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.MyViewHolder> {

    private Context context;
    private List<Serie> seriesList;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView serieImage;
        public TextView serieName;
        private View view;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.serieImage = itemView.findViewById(R.id.serie_image);
            this.serieName = itemView.findViewById(R.id.serie_title);
            this.view = itemView;
        }
    }

    public SeriesAdapter(Context context) {
        this.context = context;
        this.seriesList = Serie.prepareSeries(
                context.getResources().obtainTypedArray(R.array.seriesImages),
                context.getResources().getStringArray(R.array.seriesNames),
                context.getResources().getIntArray(R.array.seriesSeasons)
        );
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.series_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Serie serie = seriesList.get(position);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager manager = ((AppCompatActivity) context).getSupportFragmentManager();

                if (context.getResources().getBoolean(R.bool.has_two_panes)) {
                    loadSerieDetail(R.id.seasons_fragment, manager, serie);
                } else {
                    loadSerieDetail(R.id.series_list, manager, serie);
                }
            }
        });

        Glide.with(context).load(serie.getSerieImage()).into(holder.serieImage);
        holder.serieName.setText(serie.getSerieName());
    }

    private void loadSerieDetail(int id, FragmentManager manager, Serie newSerie) {

        Bundle bundle = new Bundle();
        bundle.putSerializable("SERIE", newSerie);
        bundle.putInt("LAYOUT", id);

        SeasonsFragment seasonsFragment = new SeasonsFragment();
        seasonsFragment.setArguments(bundle);

        if (id == R.id.series_list) {
            //Tablet view
            manager.beginTransaction().replace(id, seasonsFragment).addToBackStack(null).commit();
        } else {
            //Mobile phone view
            manager.beginTransaction().add(id, seasonsFragment).commit();
        }
    }

    @Override
    public int getItemCount() {
        return seriesList.size();
    }
}

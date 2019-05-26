package com.example.taller_7.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taller_7.Adapters.ChaptersAdapter;
import com.example.taller_7.R;


public class ChaptersFragment extends Fragment {

    private View context;
    private RecyclerView chaptersRecycler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        context = inflater.inflate(R.layout.chapters_layout, container, false);

        findMaterialComponents();
        setUpRecycler();

        return context;
    }

    private void setUpRecycler() {
        chaptersRecycler.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        chaptersRecycler.setLayoutManager(layoutManager);

        ChaptersAdapter chaptersAdapter = new ChaptersAdapter(context.getContext());
        chaptersRecycler.setAdapter(chaptersAdapter);
    }

    private void findMaterialComponents() {
        chaptersRecycler = context.findViewById(R.id.chapters_recyclerview);
    }
}

package com.example.taller_7.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.taller_7.Adapters.SeriesAdapter;
import com.example.taller_7.R;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class SeriesFragment extends Fragment {

    private View context;
    private FragmentManager fragmentManager;
    private BottomAppBar babSeries;
    private FloatingActionButton fabSeries;
    private RecyclerView recyclerSeries;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = inflater.inflate(R.layout.principal_container, container, false);

        setUpFragmentManager();
        findMaterialComponents();
        setUpSupportActionBar();
        fabHandler();
        setUpRecycler();

        return context;
    }

    private void setUpFragmentManager() {
        fragmentManager = getFragmentManager();
    }

    private void findMaterialComponents() {
        babSeries = context.findViewById(R.id.series_bab);
        fabSeries = context.findViewById(R.id.fab_series);
        recyclerSeries = context.findViewById(R.id.recyclerview_series);
    }

    private void setUpSupportActionBar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(babSeries);
    }

    private void fabHandler() {
        fabSeries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.series_list, new SeriesFragment()).commit();
            }
        });
    }

    private void setUpRecycler() {
        recyclerSeries.setHasFixedSize(true);

        RecyclerView.LayoutManager recycleManager = new LinearLayoutManager(getContext());
        recyclerSeries.setLayoutManager(recycleManager);

        SeriesAdapter seriesAdapter = new SeriesAdapter(context.getContext());
        recyclerSeries.setAdapter(seriesAdapter);
    }

    //Additional methods

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.bottom_bar_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

}

package com.example.taller_7.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.taller_7.R;


public class SeasonPlaceholderFragment extends Fragment {

    private View actContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        actContext = inflater.inflate(R.layout.season_placeholder, container, false);

        return actContext;
    }
}

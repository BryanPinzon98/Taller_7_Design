package com.example.taller_7.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;


import com.example.taller_7.Fragments.SeasonPlaceholderFragment;
import com.example.taller_7.Fragments.SeriesFragment;
import com.example.taller_7.R;


public class VentanaPrincipalActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private Bundle createBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        createBundle = savedInstanceState;

        setUpFragmentManager();
        inflateLayout();
    }

    private void inflateLayout() {

        if (createBundle == null) {
            fragmentManager.beginTransaction().add(R.id.series_list, new SeriesFragment()).commit();
        }

        if (getResources().getBoolean(R.bool.has_two_panes)) {
            fragmentManager.beginTransaction().add(R.id.seasons_fragment, new SeasonPlaceholderFragment()).commit();
        }
    }

    private void setUpFragmentManager() {
        fragmentManager = getSupportFragmentManager();
    }


}

package com.example.taller_7.Fragments;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taller_7.Adapters.SeasonsAdapter;
import com.example.taller_7.Entities.Serie;
import com.example.taller_7.R;


public class SeasonsFragment extends Fragment {

    private View context;
    private RecyclerView seasonsRecycler;
    private Serie serieSelected;
    private int gridSpanCount;
    private RecyclerView.LayoutManager layoutManager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = inflater.inflate(R.layout.seasons_layout, container, false);

        findMaterialComponents();
        getBundleData();
        setUpRecycler();

        return context;
    }

    private void getBundleData() {
        Bundle serieData = getArguments();
        serieSelected = (Serie) serieData.getSerializable("SERIE");
        gridSpanCount = serieData.getInt("LAYOUT");
    }

    private void findMaterialComponents() {
        seasonsRecycler = context.findViewById(R.id.seasons_recyclerview);
    }

    private void setUpRecycler() {
        seasonsRecycler.setHasFixedSize(true);
        checkGridSpanCount();


        seasonsRecycler.setLayoutManager(layoutManager);
        SeasonsAdapter seasonsAdapter = new SeasonsAdapter(context.getContext(), serieSelected.getSeasonsQuantity());
        seasonsRecycler.setAdapter(seasonsAdapter);
    }

    private void checkGridSpanCount() {

        if (gridSpanCount == R.id.series_list) {
            layoutManager = new GridLayoutManager(getContext(), 2);
            seasonsRecycler.addItemDecoration(new GridSpacingItemDecoration(6, dpToPx(5), true));
        } else {
            layoutManager = new GridLayoutManager(getContext(), 3);
            seasonsRecycler.addItemDecoration(new GridSpacingItemDecoration(6, dpToPx(10), true));

        }

    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}

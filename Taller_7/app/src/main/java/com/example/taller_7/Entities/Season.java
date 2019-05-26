package com.example.taller_7.Entities;

import android.content.res.TypedArray;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Season implements Serializable {

    private int seasonImage;
    private String seasonName;

    public Season(int seasonImage, String seasonName) {
        this.seasonImage = seasonImage;
        this.seasonName = seasonName;
    }

    public static List<Season> prepareSeasons(TypedArray seasonsImages, String[] seasonsNames, int seasonsQuantity){

        List<Season> seasons = new ArrayList<>(seasonsQuantity);

        for(int i = 0; i < seasonsQuantity; i++){
            Season newSeason = new Season(seasonsImages.getResourceId(i, -1), seasonsNames[i]);
            seasons.add(newSeason);
        }

        return seasons;
    }

    public int getSeasonImage() {
        return seasonImage;
    }

    public void setSeasonImage(int seasonImage) {
        this.seasonImage = seasonImage;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }
}

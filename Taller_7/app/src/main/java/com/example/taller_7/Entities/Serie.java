package com.example.taller_7.Entities;

import android.content.res.TypedArray;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Serie implements Serializable {

    private int serieImage;
    private String serieName;
    private int seasonsQuantity;

    public Serie(int serieImage, String serieName, int seasonsQuantity) {
        this.serieImage = serieImage;
        this.serieName = serieName;
        this.seasonsQuantity = seasonsQuantity;
    }

    public static List<Serie> prepareSeries(TypedArray seriesImages, String[] seriesNames, int[] seriesSeasons){

        List<Serie> series = new ArrayList<>(seriesNames.length);

        for(int i = 0; i < seriesImages.length(); i++){
            Serie serie = new Serie(seriesImages.getResourceId(i, -1), seriesNames[i], seriesSeasons[i]);
            series.add(serie);
        }

        return series;
    }

    public int getSerieImage() {
        return serieImage;
    }

    public void setSerieImage(int serieImage) {
        this.serieImage = serieImage;
    }

    public String getSerieName() {
        return serieName;
    }

    public void setSerieName(String serieName) {
        this.serieName = serieName;
    }

    public int getSeasonsQuantity() {
        return seasonsQuantity;
    }

    public void setSeasonsQuantity(int seasonsQuantity) {
        this.seasonsQuantity = seasonsQuantity;
    }
}

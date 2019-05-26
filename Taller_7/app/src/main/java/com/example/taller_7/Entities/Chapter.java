package com.example.taller_7.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Chapter implements Serializable {


    private String chapterTitle, chapterName, chapterDuration;

    public Chapter(String chapterTitle, String chapterName, String chapterDuration) {
        this.chapterTitle = chapterTitle;
        this.chapterName = chapterName;
        this.chapterDuration = chapterDuration;
    }

    public static List<Chapter> prepareChapters(String[] chaptersTitles, String[] chaptersNames, String[] chaptersDurations) {

        List<Chapter> chapters = new ArrayList<>(chaptersTitles.length);

        for (int i = 0; i < chaptersTitles.length; i++) {

            Chapter chapter = new Chapter(chaptersTitles[i], chaptersNames[i], chaptersDurations[i]);
            chapters.add(chapter);
        }

        return chapters;
    }

    public String getChapterTitle() {
        return chapterTitle;
    }

    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getChapterDuration() {
        return chapterDuration;
    }

    public void setChapterDuration(String chapterDuration) {
        this.chapterDuration = chapterDuration;
    }
}

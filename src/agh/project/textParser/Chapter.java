package agh.project.textParser;

import java.util.LinkedList;

/**
 * Created by Matthew on 2016-12-01.
 */
public class Chapter {

    int firstArticle;
    int lastArticle;
    String chapterTitle;
    LinkedList<String> Articles;

    public Chapter(int startAr, int endArt, String title){
        this.firstArticle = startAr;
        this.lastArticle = endArt;
        this.chapterTitle = title;
        Articles = new LinkedList<>();

    }
    public void newEnd(int newPoint){
        this.lastArticle = newPoint;
    }
}

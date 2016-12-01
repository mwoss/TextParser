package agh.project.textParser;

/**
 * Created by Matthew on 2016-11-30.
 */
public interface ITextOut {
    //write a single article
    void writeArticle(int a);
    //write artivles in range (a,b)
    void writeArticles(int a, int b);
    //write whole chapter
    void writeChapter(int a);
}

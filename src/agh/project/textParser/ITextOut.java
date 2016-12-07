package agh.project.textParser;

/**
 * Created by Matthew on 2016-11-30.
 */
public interface ITextOut {

    //write a single article in console
    void writeArticle(int a);
    //write articles in range (a,b) in console
    void writeArticles(int a, int b);
    //write whole chapter in console
    void writeChapter(int a);
    //print result in console
    void printResult(ParseArgs argParsing,TextOut out, String[] args);



    //DONT KNOW IF IM GONNA IMPLEMENT BELOW METHODS

    //write a single article to txt file
    void writeArticleToTxt(int a);
    //write articles in range (a,b) to txt file
    void writeArticlesToTxt(int a, int b);
    //write whole chapter to txt file
    void writeChapterToTxt(int a);
}

package agh.project.textParser;

/**
 * Created by Matthew on 2016-11-30.
 */
public class TextOut implements ITextOut{

    private Parser parsedText;
    public TextOut(Parser Text){
        this.parsedText = Text;
    }

    @Override
    public void writeArticle(int a) {
        int startCount=0;
        mainLoop:
        for(Chapter iter : parsedText.chapters){
            if(iter.firstArticle <= a && iter.lastArticle >= a){
                startCount = iter.firstArticle;
            }
            for(String iter2 : iter.Articles){
                if(startCount == a) {
                    System.out.println(iter2);
                    break mainLoop;
                }
                startCount++;
            }
        }
    }

    @Override
    public void writeArticles(int a, int b) {
        int startCount=0;
        mainLoop:
        for(Chapter iter : parsedText.chapters){
            if(iter.firstArticle <= a){
                startCount = iter.firstArticle;
            }
            for(String iter2 : iter.Articles){
                if(startCount >= a && startCount <= b) {
                    System.out.println(iter2);
                    if(startCount == b)
                        break mainLoop;
                }
                startCount++;
            }
        }

    }

    @Override
    public void writeChapter(int a) {
        int startCount = 1;
        for (Chapter iter : parsedText.chapters) {
            if (startCount == a) {
                System.out.println(iter.chapterTitle);
                for (String iter2 : iter.Articles) {
                    System.out.println(iter2);
                }
                break;
            }
            startCount++;
        }
    }

    @Override
    public void printResult(ParseArgs argParsing, TextOut out, String[] args) {
        if(argParsing.getProcedure() == 1){
            out.writeArticle(Integer.parseInt(args[1]));
        }
        else if(argParsing.getProcedure() == 3){
            out.writeArticles(Integer.parseInt(args[1]),Integer.parseInt(args[2]));
        }
        else{
            RomanToDecimal parseChapter = new RomanToDecimal();
            out.writeChapter(parseChapter.romanToDecimal(args[1]));
        }
    }

    @Override
    public void writeArticleToTxt(int a) {

    }

    @Override
    public void writeArticlesToTxt(int a, int b) {

    }

    @Override
    public void writeChapterToTxt(int a) {

    }
}

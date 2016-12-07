package agh.project.textParser;

import java.util.LinkedList;

/**
 * Created by Matthew on 2016-11-30.
 */
public class Parser {

    Text fileToParse;
    public LinkedList<Chapter> chapters;
    public Parser(Text inPut){
        this.fileToParse = inPut;
        this.chapters = null;
    }

    int iter = 0;

    public void Parse(){

        this.chapters = new LinkedList<Chapter>();
        boolean firstPartSkip = true;
        String nextLine;
        Chapter newChapter = new Chapter(1000,1000,"newChapter");
        int numberOfChaspters = 0;
        int numberOfArt = 0;
        boolean flagArt = false;
        boolean dashFlag = false;

        while(this.fileToParse.inText.hasNext()){
            iter++;
            nextLine = this.fileToParse.inText.nextLine();
            if(nextLine.matches("©Kancelaria Sejmu") || nextLine.matches("20..-..-..")) {
                continue;
            }
            else if(!firstPartSkip){
                if(nextLine.matches("Rozdział.*")){
                    numberOfChaspters++;
                    if(numberOfChaspters > 1)
                        this.chapters.add(newChapter);

                    boolean flag = false;
                    while(!flag){
                        nextLine += ("\n" +fileToParse.inText.nextLine());
                        if(fileToParse.inText.hasNext("Art.*"))
                            flag = true;
                    }
                    numberOfArt++;
                    newChapter = new Chapter(numberOfArt,numberOfArt,nextLine);
                    flagArt = true;

                }
                else if(nextLine.matches("Art.*")){
                    if(!flagArt){
                        numberOfArt++;
                        newChapter.Articles.add((nextLine));
                        newChapter.newEnd(numberOfArt);
                    }
                    else{
                        flagArt = false;
                        newChapter.Articles.add(nextLine);
                    }

                }
                else{
                    if(dashFlag){
                        String[] parts = nextLine.split("\\s+");
                        newChapter.Articles.set(newChapter.Articles.size()-1,newChapter.Articles.getLast().substring(0,newChapter.Articles.getLast().length()-1) + parts[0]);
                        StringBuilder builder = new StringBuilder();
                        for(String s : parts) {
                            if(s == parts[0]) continue;
                            builder.append(s);
                            if(s != parts[parts.length-1])
                                builder.append(" ");
                        }
                        if(parts.length == 1)
                            newChapter.Articles.set(newChapter.Articles.size()-1,newChapter.Articles.getLast() + builder.toString());
                        else
                            newChapter.Articles.set(newChapter.Articles.size()-1,newChapter.Articles.getLast() +"\n" + builder.toString());
                        if(nextLine.endsWith("-")){
                            dashFlag = true;
                        }
                        else{
                            dashFlag = false;
                        }
                    }
                    else{
                        if(nextLine.endsWith("-")){
                            dashFlag = true;
                        }
                        newChapter.Articles.set(newChapter.Articles.size()-1,newChapter.Articles.getLast() +"\n" + nextLine);
                    }

                }

            }
            else{
                if(nextLine.matches("^skiej.")) {
                    firstPartSkip = false;
                }
            }

        }
        this.chapters.add(newChapter);
    }
}

package agh.project.textParser;

import java.io.FileNotFoundException;

/**
 * Created by Matthew on 2016-11-30.
 */
public class TextSystem {


    public static void main (String[] args){
        try {
            //ParseArgs argParsing = new ParseArgs(args); // Passing command line arg to check_class
           /* if(argParsing.argTest()) {
                String file = args[0];
                Text x = new Text(file);
                System.out.println(x.inText.nextLine());
            }*/
            String file = args[0];
            Text F = new Text(file);
            Parser parser = new Parser(F);
            parser.Parse();
            /*for(Chapter iter : parser.chapters){
                System.out.println(iter.chapterTitle);
                for(String iter2 : iter.Articles){
                    System.out.println(iter2);
                }
            }*/
            TextOut out = new TextOut(parser);
            out.writeChapter(3);
        }catch(FileNotFoundException x) {
            System.out.println(x.getMessage());
        }
    }

}



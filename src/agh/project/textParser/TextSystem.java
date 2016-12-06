package agh.project.textParser;

import java.io.FileNotFoundException;

/**
 * Created by Matthew on 2016-11-30.
 */
public class TextSystem {


    public static void main (String[] args){
        try {
            ParseArgs argParsing = new ParseArgs(args); // Passing command line arg to check_class
           if(argParsing.argTest()) {
               String file = args[0];
               Text x = new Text(file);
               Parser parser = new Parser(x);
               parser.Parse();
               TextOut out = new TextOut(parser);
               if(argParsing.getProcedure() == 1){
                   out.writeArticle(args[1]);
               }
               else if(argParsing.getProcedure() == 2){
                   out.writeArticles(args[1],args[2]);
               }
               else{
                   out.writeChapter(args[1]);
               }

            }
           /* String file = args[0];
            Text F = new Text(file);
            Parser parser = new Parser(F);
            parser.Parse();
            TextOut out = new TextOut(parser);
            out.writeChapter(3);*/
        }catch(FileNotFoundException x) {
            System.out.println(x.getMessage());
        }
    }

}



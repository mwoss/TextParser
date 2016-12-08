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
               out.printResult(argParsing,out,args);

            }
        }catch(FileNotFoundException | IllegalArgumentException | IndexOutOfBoundsException x) {
            System.out.println(x.getMessage());
        }
    }

}



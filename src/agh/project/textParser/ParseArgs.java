package agh.project.textParser;

/**
 * Created by Matthew on 2016-12-01.
 */
public class ParseArgs extends TextSystem{
    private String[] arguments;
    private int procedure = 0; // start value
    public ParseArgs(String [] args){

        this.arguments = args;
    }
    /*
      PROCEDURES:
        0 - sth goes wrong, throw exception
        1 - write a single article
        2 - write a chapter
        3 - write articles in certain range
    */

    public boolean argTest(){
        if(arguments.length != 2 && arguments.length != 3){
            throw new IllegalArgumentException("Incorrect numbers of arguments");
        }
        else{
            if(!arguments[0].endsWith(".txt")){
                throw new IllegalArgumentException("Incorrect file extension");
            }
            else if(arguments.length == 2) {
                if(!arguments[1].matches("[MDCLXVImdclxvi]*") && !arguments[1].matches("^[0-9]+$")){
                    throw new IllegalArgumentException("Incorrect chapter's or article's number");
                }
                else if(arguments[1].matches("^[0-9]+$")){
                    procedure = 1;
                }
                else{
                    procedure = 2;
                }
            }
            else{
                if(!arguments[1].matches("^[0-9]+$") && !arguments[2].matches("^[0-9]+$")){
                    throw new IllegalArgumentException("Argument - Range of articles, are incorrect");
                }
                else{
                    procedure = 3;
                }
            }
        }
        return true;

    }
    public int getProcedure(){

        return procedure;
    }
}

package agh.project.textParser;

/**
 * Created by Matthew on 2016-12-01.
 */
public class ParseArgs extends TextSystem{
    private String[] arguments;
    public ParseArgs(String [] args){
        this.arguments = args;
    }

    public boolean argTest(){
        if(arguments.length != 2 || arguments.length != 3){
            throw new IllegalArgumentException("Incorrect numbers of arguments");
        }
        else{
            if(!arguments[0].endsWith(".txt")){
                throw new IllegalArgumentException("Incorrect file extension");
            }
            else if(arguments.length == 2) {
                if(!arguments[1].matches("[MDCLXVI]*") && !arguments[1].matches("^[0-9]+$")){
                    throw new IllegalArgumentException("Incorrect chapter's or article's number");
                }
            }
            else{
                if(!arguments[1].matches("^[0-9]+$") && !arguments[2].matches("^[0-9]+$")){
                    throw new IllegalArgumentException("Argument - Range of articles, are incorrect");
                }
            }
        }
        return true;

    }
}

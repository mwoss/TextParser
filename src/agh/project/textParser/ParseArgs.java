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
            throw new IllegalArgumentException("Inncorect numbers of argumnts");
        }
        else{
            if(!arguments[0].endsWith(".txt")){
                throw new IllegalArgumentException("Inncorect file extension");
            }
            else if(arguments.length != 3) {

            }
            //else if( ){

            //}
        }
        return true;

    }
}

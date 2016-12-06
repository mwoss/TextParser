package agh.project.textParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Matthew on 2016-12-01.
 */
public class Text {
    public Scanner inText;

    public Text(String path) throws FileNotFoundException {
        this.inText = new Scanner(new FileReader(path));

    }
}

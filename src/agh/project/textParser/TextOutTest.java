package agh.project.textParser;

import org.junit.Test;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

/**
 * Created by Matthew on 2016-12-07.
 */
public class TextOutTest {
    @Test
    public void writeArticleTest() throws Exception {
        String[] arg = {"konstytucja.txt"};
        String f = arg[0];
        Text x = new Text(f);
        Parser parser = new Parser(x);
        parser.Parse();
        TextOut out = new TextOut(parser);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        out.writeArticle(2);
        assertEquals("Art. 2.\n" +
                "Rzeczpospolita Polska jest demokratycznym państwem prawnym, urzeczywistniającym\n" +
                "zasady sprawiedliwości społecznej.\r\n"
                , outContent.toString());
    }

    @Test
    public void writeArticlesTest() throws Exception {
        String[] arg = {"konstytucja.txt"};
        String f = arg[0];
        Text x = new Text(f);
        Parser parser = new Parser(x);
        parser.Parse();
        TextOut out = new TextOut(parser);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        out.writeArticles(2,3);

        assertEquals("Art. 2.\n" +
                        "Rzeczpospolita Polska jest demokratycznym państwem prawnym, urzeczywistniającym\n" +
                        "zasady sprawiedliwości społecznej.\r\n" +
                        "Art. 3.\n" +
                        "Rzeczpospolita Polska jest państwem jednolitym.\r\n"
                        , outContent.toString());

    }

    @Test
    public void writeChapterTest() throws Exception {
        String[] arg = {"konstytucja.txt"};
        String f = arg[0];
        Text x = new Text(f);
        Parser parser = new Parser(x);
        parser.Parse();
        TextOut out = new TextOut(parser);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        out.writeChapter(12);
        byte[] result = outContent.toByteArray();
        assertEquals("Rozdział XII\n" +
                "ZMIANA KONSTYTUCJI\r\n" +
                "Art. 235.\n" +
                "1. Projekt ustawy o zmianie Konstytucji może przedłożyć co najmniej 1/5 ustawowej\n" +
                "liczby posłów, Senat lub Prezydent Rzeczypospolitej.\n" +
                "2. Zmiana Konstytucji następuje w drodze ustawy uchwalonej w jednakowym\n" +
                "brzmieniu przez Sejm i następnie w terminie nie dłuższym niż 60 dni przez Senat.\n" +
                "3. Pierwsze czytanie projektu ustawy o zmianie Konstytucji może odbyć się nie\n" +
                "wcześniej niż trzydziestego dnia od dnia przedłożenia Sejmowi projektu ustawy.\n" +
                "4. Ustawę o zmianie Konstytucji uchwala Sejm większością co najmniej 2/3 głosów\n" +
                "w obecności co najmniej połowy ustawowej liczby posłów oraz Senat bezwzględną\n" +
                "większością głosów w obecności co najmniej połowy ustawowej liczby\n" +
                "senatorów.\n" +
                "5. Uchwalenie przez Sejm ustawy zmieniającej przepisy rozdziałów I, II lub XII\n" +
                "Konstytucji może odbyć się nie wcześniej niż sześćdziesiątego dnia po pierwszym\n" +
                "czytaniu projektu tej ustawy.\n" +
                "6. Jeżeli ustawa o zmianie Konstytucji dotyczy przepisów rozdziału I, II lub XII,\n" +
                "podmioty określone w ust. 1 mogą zażądać, w terminie 45 dni od dnia uchwalenia\n" +
                "ustawy przez Senat, przeprowadzenia referendum zatwierdzającego. Z wnioskiem\n" +
                "w tej sprawie podmioty te zwracają się do Marszałka Sejmu, który zarządza\n" +
                "niezwłocznie przeprowadzenie referendum w ciągu 60 dni od dnia złożenia\n" +
                "wniosku. Zmiana Konstytucji zostaje przyjęta, jeżeli za tą zmianą opowiedziała\n" +
                "się większość głosujących.\n" +
                "7. Po zakończeniu postępowania określonego w ust. 4 i 6 Marszałek Sejmu przedstawia\n" +
                "Prezydentowi Rzeczypospolitej uchwaloną ustawę do podpisu. Prezydent\n" +
                "Rzeczypospolitej podpisuje ustawę w ciągu 21 dni od dnia przedstawienia i zarządza\n" +
                "jej ogłoszenie w Dzienniku Ustaw Rzeczypospolitej Polskiej.\r\n",outContent.toString());

    }
}
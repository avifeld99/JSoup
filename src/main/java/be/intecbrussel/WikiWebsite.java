package be.intecbrussel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WikiWebsite {


    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        /**
         * Fetch the Wikipedia homepage, parse it to a DOM, and select the headlines from the In the news section into a list of Elements (online sample, full source):
         */

        Document doc;
        try {
            doc = Jsoup.connect("https://en.wikipedia.org/").get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log("------------------------------------------------------------------------");
        log("Title: " + doc.title());
        log("------------------------------------------------------------------------");
        Elements newsHeadlines = doc.select("#mp-itn b a");
        for (Element headline : newsHeadlines) {
            log("%s\n\t%s",
                    headline.attr("title"), headline.absUrl("href"));
        }
        log("------------------------------------------------------------------------");

    }

    private static void log(String msg, String... vals) {
        System.out.println(String.format(msg, vals));
    }

}

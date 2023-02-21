package be.intecbrussel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator;

import java.io.IOException;

public class MainApp {
    public static void main(String[] args) {

        Document doc = null;
        try {
            doc = Jsoup.connect("https://www.amazon.nl/gp/bestsellers/?ref_=nav_cs_bestsellers").get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(doc.title());


        //Elements elements = doc.select(".zg-carousel-general-faceout");

        /*Elements elements = doc.select(new Evaluator() {
            @Override
            public boolean matches(Element element, Element element1) {
                return element1.className().equalsIgnoreCase("zg-carousel-general-faceout");
            }
        });*/

        Elements elements = doc.select(new Evaluator.Class("zg-carousel-general-faceout"));

        for (Element element : elements) {
            System.out.println(element.text());
        }
    }
}

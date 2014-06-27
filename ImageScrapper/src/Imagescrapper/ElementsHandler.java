package Imagescrapper;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author Edward Kim
 */
public class ElementsHandler {

    public static Elements getElements(String tags, String url) throws IOException {
        Document doc = Jsoup.connect(url).userAgent("Mozilla").get();
        return doc.select(tags);
    }

}

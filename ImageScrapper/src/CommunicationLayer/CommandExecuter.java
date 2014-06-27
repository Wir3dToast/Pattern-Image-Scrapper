package CommunicationLayer;

/**
 *
 * @author Edward Kim
 */
import Imagescrapper.Identifiers.HtmlLinkIdentifier;
import Imagescrapper.Identifiers.HtmlImageIdentifier;
import Imagescrapper.DownloadManager;
import java.io.IOException;

//Acts as the class that executes all commands. 
public class CommandExecuter {

    private final HtmlLinkIdentifier par;
    private final DownloadManager im;
    private final HtmlImageIdentifier parimg;

    public CommandExecuter() throws IOException {
        par = new HtmlLinkIdentifier();
        im = new DownloadManager();
        parimg = new HtmlImageIdentifier();
    }

    public void printLinks(String url) throws IOException {
        par.printIdentifier(url);
    }

    public void printImages(String url) throws IOException {
        parimg.printIdentifier(url);
    }

    public void printImgRegex(String imgexp, String url) throws IOException {
        parimg.printWantedIdentifier(imgexp, url);
    }

    public void printLinksRegex(String linkexp, String url) throws IOException {
        par.printWantedIdentifier(linkexp, url);
    }

    public void ScrapAllImages(String url, String directory) throws IOException {
        im.ProcessAllImages(url, directory);
    }

    //Directly uses URLs captured as the download link. Does not probe the URL's webpage.
    public void DirectDownload(String linkexp, String url, String directory) throws IOException {
        im.InitializeRegexDownload(linkexp,url,directory,false);
    }

    //Goes to the regex links and probes all of the images on the webpage
    public void ScrapRegexLinks(String linkexp, String url, String directory) throws IOException {
        im.InitializeRegexDownload(linkexp,url,directory,true);
    }

    public void ScrapRegexImageLink(String linkexp, String imgexp, String url, String directory) throws IOException {
        im.RegexCombined(linkexp, imgexp, url,directory);
    }

    public void ScrapRegexImages(String imgexp, String url,String directory) throws IOException {
        im.RegexImageDownload(url,imgexp,directory);
    }
}

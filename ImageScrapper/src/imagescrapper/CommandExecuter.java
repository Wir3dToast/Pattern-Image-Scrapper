/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imagescrapper;

/**
 *
 * @author Edward
 */

import java.io.IOException;
//Acts as the class that executes all commands. Necessary to call commands regardless if in Terminal mode or Applet mode 
public class CommandExecuter {
     private UrlParser par;
     private ImageProcessor im;
     private ImageParser parimg;
     
    public CommandExecuter() throws IOException {
        par = new UrlParser();
        im = new ImageProcessor();
        parimg = new ImageParser();    
     }
     
     public void printLinks() throws IOException {
         par.RegexDecider("",Utility.url);
     }
     
     public void printImages() throws IOException {
        parimg.printImages(Utility.url); 
     }
     
     public void printImgRegex() throws IOException {
        parimg.printWantedImages(Utility.imgexp.getText(), Utility.url);
     }     
     public void printLinksRegex() throws IOException {
       par.RegexDecider(Utility.linkexp.getText(), Utility.url);
     }
     
     public void ScrapAllImages() throws IOException {
        im.ProcessImage(Utility.url);
     }
     
     //Directly uses URLs captured as the download link. Does not probe the URL's webpage.
     public void DirectDownload() throws IOException {
         im.InitializeRegexDownload(Utility.linkexp.getText(), Utility.url, false);
     }
     
     //Goes to the regex links and probes all of the images on the webpage
     public void ScrapRegexLinks() throws IOException {
         im.InitializeRegexDownload(Utility.linkexp.getText(),Utility.url,true);
     }
     
     public void ScrapRegexImageLink() throws IOException {
         im.RegexCombined(Utility.linkexp.getText(),Utility.url, Utility.imgexp.getText());
     }
     
    public void ScrapRegexImages() throws IOException {
        im.RegexImageDownload(Utility.url, Utility.imgexp.getText());
    }
}

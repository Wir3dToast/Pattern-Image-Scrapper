/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Imagescrapper;

import Utilities.Utilities;
import Imagescrapper.Identifiers.HtmlLinkIdentifier;
import Imagescrapper.Identifiers.HtmlImageIdentifier;
import java.util.*;
import java.io.*;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.awt.color.CMMException;

import Threads.ImageSaverThread;
/**
 *
 * @author Edward Kim 
 */

//TODO: add new features with regex, make readme file better, and work on server client. Newmodes, concurrency with printstream. 
public class DownloadManager {
    
    private final HtmlImageIdentifier imgpar;
    private final HtmlLinkIdentifier urlpar;
    
    public DownloadManager() throws IOException {
        //Destination address
        //Connects and gets HTML file
         
         imgpar = new HtmlImageIdentifier();
         urlpar = new HtmlLinkIdentifier();
    }
    
    //Get ALL images on a webpage. 
    public void ProcessAllImages(String url, String directory) throws IOException {
        System.out.println("Connected to " + url);
        Elements images = ElementsHandler.getElements("[src]",url);
        
        for (Element i : images) {
            if(i.tagName().equals("img")) {
                DownloadFile(i.attr("abs:src"), directory);
            }  
        }
    }
    
    //Responsible for downloading individual files. 
    private void DownloadFile(String urlpath, String directory) {
        //Creates URL
        try {
            System.out.println("Saving Image Named " + Utilities.getLastStringFromUrl(urlpath));          
            //Start download image and Disk IO Thread
            (new ImageSaverThread(urlpath, directory)).start();        
        } catch(CMMException | IOException a) {
            System.out.println("Invalid Image format. WIP");
        }     
    }
    
    public void InitializeRegexDownload(String rule, String url, String directory, boolean ScrapLinks) throws IOException {
        //ScrapLinks boolean determines if the user wants the webpages referred to by the links to be gleaned by an image rule expression as well
        ArrayList<String> list = urlpar.imposeRules(rule,url);
        if(ScrapLinks) { 
            RegexLinkDownloadTraversal(list, directory); 
        } else { 
            DirectDownloadFromLink(list, directory); 
        }
    } 
    
    //Specify which webpages to connect to by regex expressions. 
    //Once again, it uses ProcessIamge, it gets ALL of the images on the webpage 
    private void RegexLinkDownloadTraversal(ArrayList<String> list, String directory) throws IOException {
        //Note to self: think of better wway to create URL parse. 
        for(String a : list) {
           System.out.println("Downloading from " + a);
           ProcessAllImages(a,directory);
        }       
    }
    
    // Is there a way to stop repeating this?
    //Uses URL received and DIRECTLY downloads it. 
    private void DirectDownloadFromLink(ArrayList<String> list, String directory) throws IOException {
        for(String a : list ) {
           System.out.println("Downloading Directly from " + a);
           DownloadFile(a,directory);
        }       
    }
        
    //Imposes both link and image regex rules
    public void RegexCombined (String linkregex, String imgregex, 
                               String url, String directory) throws IOException {
        ArrayList<String> list = urlpar.imposeRules(linkregex,url);
        for(String site : list) { RegexImageDownload(site,imgregex,directory); } 
    }
    
    //Imposes regex 
    public void RegexImageDownload(String url, String regex, String directory) throws IOException{
        ArrayList<String> list = imgpar.imposeRules(regex, url);
        for(String a : list) { DownloadFile(a,directory); }
    }
}
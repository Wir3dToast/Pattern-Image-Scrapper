/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imagescrapper;

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
public class ImageProcessor {
    
    private final HtmlImageParser imgpar;
    private final HtmlLinkParser urlpar;
    
    public ImageProcessor() throws IOException {
        //Destination address
        //Connects and gets HTML file
         System.out.println("Downloading to " + Utility.directory);
         
         imgpar = new HtmlImageParser();
         urlpar = new HtmlLinkParser();
    }
    
    //Get ALL images on a webpage. 
    public void ProcessImage(String url) throws IOException {
        System.out.println("Connected to " + url);
        Elements images = Utility.getElements("[src]",url);
        
        for (Element i : images) {
            if(i.tagName().equals("img")) {
                DownloadFile(i.attr("abs:src"));
            }  
        }
    }
    
    //Responsible for downloading individual files. 
    private void DownloadFile(String urlpath) {
        //Creates URL
        try {
            System.out.println("Saving Image From " + urlpath);
           
            //Start download image and Disk IO Thread
            (new ImageSaverThread(urlpath)).start();        
        } catch(CMMException | IOException a) {
            System.out.println("Invalid Image format. WIP");
        }     
    }
    
    public void InitializeRegexDownload(String regex, String url, boolean ScrapLinks) throws IOException {
        //ScrapLinks boolean determines if the user wants the webpages referred to by the links to be gleaned by an image regex expression as well
        ArrayList<String> list = urlpar.getLinks(regex,url);
        if(ScrapLinks) { 
            RegexLinkDownloadTraversal(list); 
        } else { 
            DirectDownloadFromLink(list); 
        }
    } 
    
    //Specify which webpages to connect to by regex expressions. 
    //Once again, it uses ProcessIamge, it gets ALL of the images on the webpage 
    private void RegexLinkDownloadTraversal(ArrayList<String> list) throws IOException {
        //Note to self: think of better wway to create URL parse. 
        for(String a : list ) {
           System.out.println("Downloading from " + a);
           ProcessImage(a);
        }       
    }
    
    // Is there a way to stop repeating this?
    //Uses URL received and DIRECTLY downloads it. 
    private void DirectDownloadFromLink(ArrayList<String> list) throws IOException {
        for(String a : list ) {
           System.out.println("Downloading Directly from " + a);
           DownloadFile(a);
        }       
    }
        
    //Imposes both link and image regex rules
    public void RegexCombined (String linkregex, String url, String imgregex) throws IOException {
        ArrayList<String> list = urlpar.getLinks(linkregex,url);
        for(String site : list) { RegexImageDownload(site,imgregex); } 
    }
    
    //Imposes regex 
    public void RegexImageDownload(String url, String regex) throws IOException{
        ArrayList<String> list = imgpar.imposeRules(regex, url);
        for(String a : list) { DownloadFile(a); }
    }
}
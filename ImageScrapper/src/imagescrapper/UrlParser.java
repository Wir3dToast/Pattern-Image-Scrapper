/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imagescrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.util.*;
/**
 *
 * @author Edward Kim
 */

//private class for webpage? has both url and doc in it already?

public class UrlParser {
    //Note to self: need to make ImageParser and UrlParser more consist in terms of constructors!!!
    
    public UrlParser() throws IOException {
        System.out.println("Getting links from " + Utility.url);
    }
    
    public void RegexDecider(String regex, String url) throws IOException { 
          if(regex.equals("")) {
              printLinks(url);
          } else {
             printWantedLinks(regex, url);
          }
    }  
    
    //Utility.url is subjective to change therefore I instantiate links for every single call. 
    private void printLinks(String url) throws IOException {
      //Checks to see if there is a regular expression to be executed 
        Elements links = Utility.getElements("a[href]", url);
        int counter = 0;
        
        for(Element i : links) {
            
            if(i.attr("abs:href").equals("")) {
                System.out.println("Link is Different Type: " + i.outerHtml());
            } else {
               System.out.println("Link at " + i.attr("abs:href"));
            }
            
            counter++;
      }
        
      System.out.println("=================");
      System.out.println(counter + " Links were Dectected on this Web Page");
    }   
    
    private void printWantedLinks(String regex, String url) throws IOException {
        Elements links = Utility.getElements("a[href]", url);
        for(Element i: links){
            if(i.attr("abs:href").contains(regex))
               System.out.println(i.attr("abs:href"));
        }
    }   
    
    public ArrayList<String> getLinks(String regex, String url) throws IOException {
        Elements links = Utility.getElements("a[href]", url);
        ArrayList<String> list = new ArrayList<String>();
        for(Element i : links) {
            if((i.attr("abs:href").contains(regex)) && !list.contains(i.attr("abs:href"))) {
                list.add(i.attr("abs:href"));
            }
        }        
        
        return list;  
    }
}

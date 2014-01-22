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
 * @author Edward
 */
//private class for webpage? has both url and doc in it already?
public class UrlParser {
    //Note to self: need to make ImageParser and UrlParser more consist in terms of constructors!!!
    
    public UrlParser() throws IOException{
        Utility.print("Getting links from " + Utility.url);
    }
    public void RegexDecider(String regex, String url) throws IOException{ 
          if(regex.equals("")){
              printLinks(url);
          }
          else
             printWantedLinks(regex, url);
    }  
    //Utility.url is subjective to change therefore I instantiate links for every single call. 
    private void printLinks(String url) throws IOException{
      //Checks to see if there is a regular expression to be executed 
        Elements links = Utility.getElements("a[href]", url);
        int counter = 0;
        for(Element i : links){
            counter++;
            if(i.attr("abs:href").equals("")){
                Utility.print("Link is Different Type: " + i.outerHtml());
            }
            else
               Utility.print("Link at " + i.attr("abs:href"));
      }
      Utility.print("=================");
      Utility.print(counter + " Links were Dectected on this Web Page");
    }   
    private void printWantedLinks(String regex, String url) throws IOException{
        Elements links = Utility.getElements("a[href]", url);
        for(Element i: links){
            if(i.attr("abs:href").contains(regex))
               Utility.print(i.attr("abs:href"));
        }
    }   
    //Do not use 
    public ArrayList<String> getLinks(String regex, String url) throws IOException{
        Elements links = Utility.getElements("a[href]", url);
        ArrayList<String> list = new ArrayList<String>();
        for(Element i : links)
            if((i.attr("abs:href").contains(regex)) && !list.contains(i.attr("abs:href")))
                list.add(i.attr("abs:href"));
        return list;  
    }
}
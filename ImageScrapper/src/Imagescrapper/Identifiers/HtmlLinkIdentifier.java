/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Imagescrapper.Identifiers;

import Utilities.Utilities;
import Imagescrapper.ElementsHandler;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.util.*;
/**
 *
 * @author Edward Kim
 */

//private class for webpage? has both url and doc in it already?

public class HtmlLinkIdentifier extends Identifier {

    @Override
    //Utility.url is subjective to change therefore I instantiate links for every single call. 
    public void printIdentifier(String url) throws IOException {
      //Checks to see if there is a regular expression to be executed
        
        System.out.println("Searching for Pictures for " + url);
        Elements links = ElementsHandler.getElements("a[href]", url);
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
    
    @Override
    public void printWantedIdentifier(String regex, String url) throws IOException { 
        
        Elements links = ElementsHandler.getElements("a[href]", url);
        for(Element i: links){
            if(i.attr("abs:href").contains(regex))
               System.out.println(i.attr("abs:href"));
        }
    }   
    
    @Override
    public ArrayList<String> imposeRules (String rule, String url) throws IOException {
        Elements links = ElementsHandler.getElements("a[href]", url);
        ArrayList<String> list = new ArrayList<>();
        
        for(Element i : links) {
            if((i.attr("abs:href").contains(rule)) && !list.contains(i.attr("abs:href"))) {
                list.add(i.attr("abs:href"));
            }
        }        
        
        return list;  
    }
}

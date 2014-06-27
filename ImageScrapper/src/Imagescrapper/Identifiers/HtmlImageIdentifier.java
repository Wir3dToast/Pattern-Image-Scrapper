/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Imagescrapper.Identifiers;

/**
 *
 * @author Edward Kim
 */

import Utilities.Utilities;
import Imagescrapper.ElementsHandler;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.*;

public class HtmlImageIdentifier extends Identifier {
  
  @Override
  public void printIdentifier(String url) throws IOException {
     Elements images = ElementsHandler.getElements("[src]",url);
     int counter = 0;
     for(Element i : images) {
         counter++;
        System.out.println(" Image at " + i.attr("abs:src"));
     }
     
    System.out.println("=================");
    System.out.println(counter + " Images were Dectected on this Web Page"); 
  }
  
  @Override
  public void printWantedIdentifier(String rule, String url) throws IOException {
      Elements images = ElementsHandler.getElements("[src]", url);
      
      for(Element i : images) {
         if((i.tagName().equals("img")) && (i.attr("abs:src").contains(rule))) {
            System.out.println(Utilities.getLastStringFromUrl(i.attr("abs:src")));
         }
     }
  }
  
  @Override
  //Finds all images whose url fits the user's regex expression. 
  //Perhaps we can use option for relative urls? 
  public ArrayList<String> imposeRules(String rule, String url) throws IOException {
     Elements images = ElementsHandler.getElements("[src]", url);
     ArrayList<String> list = new ArrayList<>();
     
     for(Element i : images) {
         if((i.tagName().equals("img")) && (i.attr("abs:src").contains(rule))) {
              list.add(i.attr("abs:src"));
         }      
     }
     
     return list;    
  }
}
    
    


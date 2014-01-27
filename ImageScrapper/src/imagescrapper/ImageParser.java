/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imagescrapper;

/**
 *
 * @author Edward
 */

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.*;

public class ImageParser {
       
  public void printImages(String url) throws IOException {
     Elements images = Utility.getElements("[src]",url);
     int counter = 0;
     for(Element i : images) {
         counter++;
        System.out.println(" Image at " + i.attr("abs:src"));
     }
     
    System.out.println("=================");
    System.out.println(counter + " Images were Dectected on this Web Page"); 
  }
  
  public void printWantedImages(String regex, String url) throws IOException {
      Elements images = Utility.getElements("[src]", url);
      
      for(Element i : images) {
         if((i.tagName().equals("img")) && (i.attr("abs:src").contains(regex))) {
            System.out.println(" Image at " + i.attr("abs:src"));
         }
     }
  }
  
  //Finds all images whose url fits the user's regex expression. 
  //Perhaps we can use option for relative urls? 
  public ArrayList<String> imposeRules(String regex, String url) throws IOException {
     Elements images = Utility.getElements("[src]", url);
     ArrayList<String> list = new ArrayList<>();
     
     for(Element i : images) {
         if((i.tagName().equals("img")) && (i.attr("abs:src").contains(regex))) {
              list.add(i.attr("abs:src"));
         }      
     }
     
     return list;    
  }
}
    
    


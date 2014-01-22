/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package imagescrapper;

/**
 *
 * @author Edward Kim
 */

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.Thread; 

public class Utility {
    
   //Utility class: contains methods needed universally in the program
    public static javax.swing.JTextArea TextArea;
    public static String url;
    public static javax.swing.JTextField imgexp;
    public static javax.swing.JTextField linkexp;
    public static String directory;
    
    //needed for linux and windows file system differentiation.
    public static final String OS = System.getProperty("os.name").toLowerCase();
    public static String delimiter = (OS.indexOf("win") >= 0) ? "\\" : "/";
    
    public static Elements getElements(String tags, String url) throws IOException {
        
         Document doc = Jsoup.connect(url).userAgent("Mozilla").get();
         return doc.select(tags);
    }
    
     public static boolean CheckifDirExists(String path) {
        return (new File(path)).exists();
     }
     
     public static void print(String print) {
         new Thread(new PrintThread(print)).start();
     }
     
     public static String escapeBackSlash(String path) {
         //escapes backslashes in directory pathnames 
         return path.replaceFirst("\\\\","\\\\\\\\");
     }
     
     static class PrintThread extends Thread {
  
        String line;
        
        public PrintThread(String line) {
            this.line = line;
        }
        
        public void run() {
            TextArea.append(line + '\n');
        }
     
     }

}




package Utilities;

/**
 *
 * @author Edward Kim
 */

import java.io.File;

public class Utilities {
    
    //Utility class: contains methods needed universally in the program
    
     public static boolean CheckifDirExists(String path) {
        return (new File(path)).exists();
     }
         
     public static String escapeBackSlash(String path) {
         //escapes backslashes in directory pathnames 
         return path.replaceFirst("\\\\","\\\\\\\\");
     }
     
     public static String getLastStringFromUrl(String url) {
        return url.substring(url.lastIndexOf("/") + 1);
     }

}




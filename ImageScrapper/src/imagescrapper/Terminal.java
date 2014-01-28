/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imagescrapper;

import java.io.IOException;

/**
 *
 * @author Edward
 */
public class Terminal {
     
     private final CommandExecuter com;
     
     //Initializes global url and directory. 
     public Terminal() throws IOException {
      if(Utility.CheckifDirExists(Utility.directory)) {
          System.out.println("Warning: directory does not exist");
      }
        com = new CommandExecuter();
        System.out.println("> ");
     }
     
     public void ExecuteCommand(String command) throws IOException {
        System.out.println(command);
        switch(command) {
            
            case "printlinks":com.printLinks();
                              break;
            case "printimages": com.printImages();
                                break;
            case "printlinksexp": com.printLinksRegex();
                                  break;
            case "printimgexp": com.printImgRegex();
                                break;
            case "scraplink" : com.DirectDownload();
                               break;                              
            case "deepscraplink": com.ScrapRegexLinks();
                                  break;
            case "scrapimglink": com.ScrapRegexImageLink();
                                 break;
            case "scrapimg": com.ScrapRegexImages();
                             break;                     
            default: System.out.println("Not a valid command");    
        }
        
        System.out.println("> ");
    }   
}

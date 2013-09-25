/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imagescrapper;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Edward
 */
public class Terminal {
     
     private CommandExecuter com;
     //Initializes global url and directory. 
     public Terminal() throws IOException{
      if(Utility.CheckifDirExists(Utility.directory)){
          Utility.print("Warning: directory does not exist");
      }
        com = new CommandExecuter();
        Utility.print("> ");
     }
     
     public void ExecuteCommand(String command) throws IOException{
        Utility.print(command);
        switch(command){
            
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
            default: Utility.print("Not a valid command");    
        }
        Utility.print("> ");
    }   
}

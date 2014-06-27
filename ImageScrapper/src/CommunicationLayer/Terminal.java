package CommunicationLayer;

import java.io.IOException;

/**
 *
 * @author Edward Kim
 */

/*
 *   A basic interface for the image scrapper. For mostly testing reasons. 
 */
public class Terminal {

    private final CommandExecuter com;

    //Initializes global url and directory. 
    public Terminal() throws IOException {
        com = new CommandExecuter();
    }

    //Remove case statement
    public void ExecuteCommand(ScrapperCommand comm) throws IOException {
        String directory = comm.getDirectory();
        String url = comm.getUrl();

        System.out.println("Command executed: " + comm.getCommand());

        switch (comm.getCommand()) {
            case "printlinks":
                com.printLinks(url);
                break;
            case "printimages":
                com.printImages(url);
                break;
            case "printlinksexp":
                com.printLinksRegex(((RuleScrapperCommand) comm).getLinkRule(),
                        url);
                break;
            case "printimgexp":
                com.printImgRegex(((RuleScrapperCommand) comm).getImgRule(),
                        url);
                break;
            case "scraplink":
                com.DirectDownload(((RuleScrapperCommand) comm).getLinkRule(),
                        url,
                        directory);
                break;
            case "deepscraplink":
                com.ScrapRegexLinks(((RuleScrapperCommand) comm).getLinkRule(),
                        url,
                        directory);
                break;
            case "scrapimglink":
                com.ScrapRegexImageLink(((RuleScrapperCommand) comm).getLinkRule(),
                        ((RuleScrapperCommand) comm).getImgRule(),
                        url,
                        directory);
                break;
            case "scrapimg":
                com.ScrapRegexImages(((RuleScrapperCommand) comm).getImgRule(),
                        url,
                        directory);
                break;
            default:
                System.out.println("Not a valid command");
        }
    }
}

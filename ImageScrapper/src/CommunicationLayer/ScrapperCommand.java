package CommunicationLayer;

/**
 *
 * @author Edward Kim
 */
public class ScrapperCommand {
    private String Directory;
    private String Command;
    private String Url;
    
    public ScrapperCommand(String command,String directory,String url) {
        this.Directory = directory;
        this.Command = command;
        this.Url = url;
    }
    
    public String getDirectory() {
        return Directory;
    }
    
    public String getCommand() {
        return Command;
    }
    
    public String getUrl() {
        return Url;
    }
}

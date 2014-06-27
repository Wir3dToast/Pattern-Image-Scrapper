package CommunicationLayer;

/**
 *
 * @author Edward Kim
 */
public class RuleScrapperCommand extends ScrapperCommand {

    private String ImgRule;
    private String LinkRule;

    public RuleScrapperCommand(String directory, String command, String url,
                                String imgrule, String linkrule) {
        super(directory,command,url);
        ImgRule = imgrule;
        LinkRule = linkrule;
    }
    
    public String getImgRule() {
        return ImgRule;
    }
    
    public String getLinkRule() {
        return LinkRule;
    }
}

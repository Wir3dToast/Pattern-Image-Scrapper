package Imagescrapper.Identifiers;

import java.util.ArrayList;
import java.io.IOException;
/**
 *
 * @author Edward Kim
 */
public abstract class Identifier {
    
    abstract void printIdentifier(String url) throws IOException;
    
    abstract void printWantedIdentifier(String rule, String url) throws IOException;
    
    abstract ArrayList<String> imposeRules(String rule, String url) throws IOException;
    
}

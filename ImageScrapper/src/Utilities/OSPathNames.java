package Utilities;

/**
 *
 * @author Edward Kim
 */
public class OSPathNames {
    //needed for linux and windows file system differentiation.
    public static final String OS = System.getProperty("os.name").toLowerCase();
    public static final String delimiter = (OS.indexOf("win") >= 0) ? "\\" : "/";
}

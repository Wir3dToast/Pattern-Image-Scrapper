package SimpleApplet;


import java.io.PrintStream;
import java.io.OutputStream;
import javax.swing.JTextArea;
/**
 *
 * @author Edward Kim
 */
public class TextAreaPrintStream extends PrintStream {

    private final JTextArea textarea;
    
    public TextAreaPrintStream(JTextArea area, OutputStream output) {
        super(output,true);
        textarea = area;
    }
    
    @Override
    public void println(String str) {
       (new TextAreaPrintThread(textarea,str + '\n')).start();
    }
    
    @Override
    public void print(String str) {
       (new TextAreaPrintThread(textarea,str)).start();
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.io.PrintStream;
import java.io.Writer;
import java.io.OutputStream;
import javax.swing.JTextArea;
/**
 *
 * @author edward
 */
public class TextAreaPrintStream extends PrintStream {

    private JTextArea textarea;
    
    public TextAreaPrintStream(JTextArea area, OutputStream output) {
        super(output,true);
        textarea = area;
    }
    
    @Override
    public void println(String str) {
       textarea.append((str + '\n'));
    }
    
    @Override
    public void print(String str) {
       textarea.append(str);
    }
}

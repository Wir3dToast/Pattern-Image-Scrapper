/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Threads.TextAreaPrintThread;

import java.io.PrintStream;
import java.io.OutputStream;
import javax.swing.JTextArea;
/**
 *
 * @author edward
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

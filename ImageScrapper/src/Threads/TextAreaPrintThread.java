/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Threads;

import javax.swing.JTextArea;

/**
 *
 * @author Edward Kim
 */

public class TextAreaPrintThread extends Thread {
    
    private final String Message;
    private final JTextArea TextArea;
    
    public TextAreaPrintThread(JTextArea textarea, String message) {
        Message = message;
        TextArea = textarea;
    }
    
    public void run() {
        TextArea.append(Message);
    }
    
}

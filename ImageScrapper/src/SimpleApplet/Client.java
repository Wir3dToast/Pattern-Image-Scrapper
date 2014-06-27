package SimpleApplet;

/* Imagescrapper libraries */
import CommunicationLayer.*;
import Utilities.Utilities;

/* swing libraries */

import javax.swing.JFileChooser;
/* io libraries */
import java.io.IOException;
import java.lang.NullPointerException;

/**
 *
 * @author Edward Kim
 */
public class Client extends javax.swing.JFrame {
    
/* instance fields */    
private Terminal Term;
private String Directory;
private String Url;

    /**
     * Creates new form MainWindow
     */
    public Client() {
        initComponents();
        setComVisible(true);
        
        FileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        TextArea.setEditable(false);
        
        /* Set the linkexp and imgexp boxes to static fields in Utility class */
        TextAreaPrintStream output = new TextAreaPrintStream(TextArea,System.out); /* Set outputstream to text area for applet implementation */
        System.setOut(output);
        
        try {
            Term = new Terminal();
        } catch (IOException a) {
            a.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FileChooser = new javax.swing.JFileChooser();
        jPanel3 = new javax.swing.JPanel();
        UrlField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        DirectoryButton = new javax.swing.JButton();
        CommandBox = new javax.swing.JTextField();
        CommandLabel = new javax.swing.JLabel();
        LinkExp = new javax.swing.JTextField();
        LinkExpLabel = new javax.swing.JLabel();
        ImgExp = new javax.swing.JTextField();
        ImgLabel = new javax.swing.JLabel();
        CommandEnterButton = new javax.swing.JButton();
        ClearTextAreaButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        UrlField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UrlFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Url Field");

        DirectoryButton.setText("Choose Directory");
        DirectoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DirectoryButtonActionPerformed(evt);
            }
        });

        CommandBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CommandBoxActionPerformed(evt);
            }
        });

        CommandLabel.setText("Command Field");

        LinkExpLabel.setText("Link Regex Expression");

        ImgLabel.setText("Image Regex Expression");

        CommandEnterButton.setText("Enter Command");
        CommandEnterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CommandEnterButtonActionPerformed(evt);
            }
        });

        ClearTextAreaButton.setText("Clear Text Area");
        ClearTextAreaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearTextAreaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(CommandLabel)
                                .addGap(270, 270, 270)
                                .addComponent(LinkExpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(UrlField, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                    .addComponent(CommandBox))
                                .addGap(169, 169, 169)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(DirectoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                    .addComponent(LinkExp))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(ImgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ImgExp, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ClearTextAreaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CommandEnterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(244, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DirectoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(UrlField)
                    .addComponent(ClearTextAreaButton))
                .addGap(52, 52, 52)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CommandLabel)
                    .addComponent(LinkExpLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ImgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CommandBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LinkExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImgExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CommandEnterButton))
                .addContainerGap())
        );

        TextArea.setColumns(20);
        TextArea.setRows(5);
        jScrollPane1.setViewportView(TextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1484, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CommandEnterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CommandEnterButtonActionPerformed
        ExecuteCommand(CommandBox.getText(),LinkExp.getText(),ImgExp.getText());
    }//GEN-LAST:event_CommandEnterButtonActionPerformed

    private void CommandBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CommandBoxActionPerformed
        ExecuteCommand(CommandBox.getText(),LinkExp.getText(),ImgExp.getText());
    }//GEN-LAST:event_CommandBoxActionPerformed

    private void DirectoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DirectoryButtonActionPerformed
        if(FileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){  /* Set directory options */
            Directory = Utilities.escapeBackSlash((FileChooser.getSelectedFile()).getAbsolutePath());
            System.out.println("Directory set to " + Directory);
        }
    }//GEN-LAST:event_DirectoryButtonActionPerformed

    private void UrlFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UrlFieldActionPerformed
        Url= UrlField.getText();
        System.out.println("Url set to " + Url);
        UrlField.setText("");
    }//GEN-LAST:event_UrlFieldActionPerformed

    private void ClearTextAreaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearTextAreaButtonActionPerformed
        TextArea.setText(null);
    }//GEN-LAST:event_ClearTextAreaButtonActionPerformed

       
    private void ExecuteCommand(String command, String linkexp, String imgexp) {
        if(Directory == null || Url == null) {
            System.out.println("Directory or Url not set");
        }
        ScrapperCommand newcommand = (linkexp.equals("") && imgexp.equals("")) ? new ScrapperCommand(command,Directory,Url) 
                                                                               : new RuleScrapperCommand(command,Directory,Url,imgexp,linkexp);
            try {
                Term.ExecuteCommand(newcommand);
            } catch (IOException a) {
                a.printStackTrace();
            }
    }

    private void setComVisible(boolean bo) {
        
          CommandBox.setVisible(bo);
          CommandLabel.setVisible(bo);
          LinkExp.setVisible(bo);
          LinkExpLabel.setVisible(bo);
          ImgExp.setVisible(bo);
          ImgLabel.setVisible(bo);
          CommandEnterButton.setVisible(bo);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
            }
        });
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearTextAreaButton;
    private javax.swing.JTextField CommandBox;
    private javax.swing.JButton CommandEnterButton;
    private javax.swing.JLabel CommandLabel;
    private javax.swing.JButton DirectoryButton;
    private javax.swing.JFileChooser FileChooser;
    private javax.swing.JTextField ImgExp;
    private javax.swing.JLabel ImgLabel;
    private javax.swing.JTextField LinkExp;
    private javax.swing.JLabel LinkExpLabel;
    private javax.swing.JTextArea TextArea;
    private javax.swing.JTextField UrlField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
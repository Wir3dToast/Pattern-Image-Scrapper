/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Threads;

import Utilities.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import javax.imageio.ImageIO;

/**
 *
 * @author Edward Kim
 */
public class ImageSaverThread extends Thread {
    
    private final String Url;
    private final String DirectoryPath;
    
    public ImageSaverThread(String url, String directory) throws IOException {
        Url = url;
        DirectoryPath = directory;
    }
    
    private void SaveImage() throws IOException {
        URLConnection conn = (new URL(Url)).openConnection();
        conn.setRequestProperty("User-Agent", "Mozilla");
        BufferedImage Image = ImageIO.read(conn.getInputStream());
        
        String picname = Utilities.getLastStringFromUrl(Url);
        String format = picname.substring(picname.lastIndexOf(".") + 1);
        
        ImageIO.write(Image, format, new File(DirectoryPath + OSPathNames.delimiter + picname));
    }
    
    @Override
    public void run() {
        try {
            SaveImage();
        } catch (IOException ex) {
            System.out.println("IOEXCEPTION!: Stopping ImageSaver thread now" + ex.getMessage());
        }
    }  
}

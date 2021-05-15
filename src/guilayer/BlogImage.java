package guilayer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BlogImage extends JPanel{

    private BufferedImage image;

    public BlogImage(String path) {
       try {
    	  File file = new File(path);
    	  if(file.exists()) {
    		  image = ImageIO.read(new File(path));    		  
    	  }
       } catch (IOException ex) {
            
       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);          
    }

}
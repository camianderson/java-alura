import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class StickerGenerator {
    
    public void generate() throws Exception {

        //read the image
        BufferedImage originalImg = ImageIO.read(new File("img/movie.jpeg"));

        //create the new image in the memory with transparency and new size
        int width = originalImg.getWidth();
        int height = originalImg.getHeight();
        int newHeight = height + 200;
        BufferedImage newImg = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        //copy the original image to the new image (in the memory)
        Graphics2D graphics = (Graphics2D) newImg.getGraphics();
        graphics.drawImage(originalImg,  0, 0, null);

        //write something in the image
        

        //write the new image in a file
        ImageIO.write(newImg, "png", new File("exit/sticker.png"));
    }

}

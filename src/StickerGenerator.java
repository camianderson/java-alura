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
    }

}

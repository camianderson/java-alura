import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.FontMetrics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.awt.Color;
import java.awt.Font;

import javax.imageio.ImageIO;

public class StickerGenerator {
    
    public void generate(InputStream inputStream, String nameFile) throws Exception {

        //read the image
        BufferedImage originalImg = ImageIO.read(inputStream);

        //create the new image in the memory with transparency and new size
        int width = originalImg.getWidth();
        int height = originalImg.getHeight();
        int newHeight = height + 100;
        BufferedImage newImg = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        //copy the original image to the new image (in the memory)
        Graphics2D graphics = (Graphics2D) newImg.getGraphics();
        graphics.drawImage(originalImg,  0, 0, null);

        //add font details to image
        var font = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(font);

        //write something in the image
        String text = "AWESOME";
        FontMetrics fontMetrics = graphics.getFontMetrics();
        Rectangle2D rectangle = fontMetrics.getStringBounds(text, graphics);
        int textWidth = (int) rectangle.getWidth();
        int textPositionX = (width - textWidth)/2;

        graphics.drawString(text, textPositionX, newHeight-25);

        //write the new image in a file
        ImageIO.write(newImg, "png", new File("exit/" + nameFile));
    }

}

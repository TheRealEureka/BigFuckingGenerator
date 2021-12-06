import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Example
{
    public static void main(String[] args)
    {
        int pixel_size = 25;
        // Image file dimensions
        int width = 500, height = 500;

        //Filter parameters
        Color color = new Color(255,255,255, 125);


        // Create buffered image object
        BufferedImage filter = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        BufferedImage img = BigFuckingEditor.generateImage(pixel_size, width, height);

        //Set filter color to white
        Graphics2D graphics = filter.createGraphics();
        graphics.setPaint (color);
        graphics.fillRect ( 0, 0, filter.getWidth(), filter.getHeight() );



        BigFuckingEditor.paintOver(img, filter, 0, 0);

        BigFuckingEditor.textOver(img, "BFG Project", 125, 250, 50, Color.BLACK);

        // write image
        try
        {
            File f = new File("generated/init2.png");
            ImageIO.write(img, "png", f);

        }
        catch(IOException e)
        {
            System.out.println("Error: " + e);
        }
    }
}
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Test1
{
    public static void main(String args[])throws IOException
    {
        // Image file dimensions
        int width = 500, height = 500;

        //Filter parameters
        Color color = new Color(255,255,255, 45);


        // Create buffered image object
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        BufferedImage filter = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        //Set color to white

        Graphics2D graphics = filter.createGraphics();
        graphics.setPaint (color);
        graphics.fillRect ( 0, 0, filter.getWidth(), filter.getHeight() );

        // create random values pixel by pixel
        for (int y = 0; y < height; y=y+2)
        {
            for (int x = 0; x < width; x=x+2)
            {
                // generating values less than 256
                int a = 255;
                int r = (int)(Math.random()*256);
                int g = (int)(Math.random()*256);
                int b = (int)(Math.random()*256);

                //pixel
                int p = (a<<24) | (r<<16) | (g<<8) | b;

                img.setRGB(x, y, p);
                img.setRGB(x+1, y, p);
                img.setRGB(x, y+1, p);
                img.setRGB(x+1, y+1, p);
            }
        }
        //Adding alpha filter


        img = BigFuckingEditor.paintOver(img, filter, 0, 0);

        // write image
        try
        {
            File f = new File("generated/init.png");
            ImageIO.write(img, "png", f);

        }
        catch(IOException e)
        {
            System.out.println("Error: " + e);
        }
    }
}
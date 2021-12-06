import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Test2
{
    public static void main(String args[])throws IOException
    {
        int pixel_size = 50;
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
        for (int i = 0; i < height; i=i+pixel_size)
        {
            for (int y = 0; y < width; y=y+pixel_size)
            {
                // generating values less than 256
                int a = 255;
                int r = (int)(Math.random()*256);
                int g = (int)(Math.random()*256);
                int b = (int)(Math.random()*256);

                //pixel
                int p = (a<<24) | (r<<16) | (g<<8) | b;

                for(int x = 0 ; x <pixel_size ; x++)
                {
                    for(int z = 0 ; z <pixel_size ; z++)
                    {
                        img.setRGB(y+x, i+z, p);
                    }
                }

            }
        }
        //Adding alpha filter


        img = BigFuckingEditor.paintOver(img, filter, 0, 0);

        img = BigFuckingEditor.textOver(img, "Clément le moche", 40, 250, 50, Color.BLACK);

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
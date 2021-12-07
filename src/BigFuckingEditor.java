import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class BigFuckingEditor {

    //Paint an image over another
    public static void paintOver(BufferedImage back, BufferedImage top,  int decalx, int decaly){
        int sizex = top.getWidth();
        int sizey = top.getHeight();

        Graphics g=back.getGraphics();
        g.drawImage(top, decalx, decaly, decalx+sizex, decaly+sizey, 0, 0, sizex, sizey, null);
        g.dispose();
    }
    //Paint text over an image
    public static void textOver(BufferedImage img, String txt, int x, int y, int size, Color c){
        Graphics g=img.getGraphics();

        if(c!=null)
        {
            g.setColor(c);
        }
        //On macos Monterey you wil need ton install "Times" font (https://www.freebestfonts.com/timr45w-font)
        g.setFont(new Font("Times", Font.PLAIN, size));
        g.drawString(txt,x,y);
        g.dispose();
    }
    //Apply blur on image
    public static void blurImage(BufferedImage img)
    {
        Kernel kernel = new Kernel(3, 3, new float[] { 0.0625f, 0.125f, 0.0625f, 0.125f, 0.25f, 0.125f,
                0.0625f, 0.125f, 0.0625f});
        BufferedImageOp op = new ConvolveOp(kernel);
         op.filter(img, null);
    }
    //Generate random image
    public static BufferedImage generateImage(int px_size, int width, int height)
    {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < height; i=i+px_size)
        {
            for (int y = 0; y < width; y=y+px_size)
            {
                // generating values less than 256
                int a = 255;
                int r = (int)(Math.random()*256);
                int g = (int)(Math.random()*256);
                int b = (int)(Math.random()*256);

                //pixel
                int p = (a<<24) | (r<<16) | (g<<8) | b;

                for(int x = 0 ; x <px_size ; x++)
                {
                    for(int z = 0 ; z <px_size ; z++)
                    {

                            img.setRGB(y+x, i+z, p);


                    }
                }

            }
        }

    return img;
    }
}


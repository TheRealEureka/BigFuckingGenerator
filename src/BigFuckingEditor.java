import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class BigFuckingEditor {

    //Paint an image over another
    public static BufferedImage paintOver(BufferedImage back, BufferedImage top,  int decalx, int decaly){
        int sizex = top.getWidth();
        int sizey = top.getHeight();

        Graphics g=back.getGraphics();
        g.drawImage(top, decalx, decaly, decalx+sizex, decaly+sizey, 0, 0, sizex, sizey, null);
        g.dispose();

        return back;
    }

    //Paint text over an image
    public static BufferedImage textOver(BufferedImage img, String txt, int x, int y, int size, Color c){
        Graphics g=img.getGraphics();

        if(c!=null)
        {
            g.setColor(c);
        }
        g.setFont(new Font("Serif", Font.PLAIN, size));
        g.drawString(txt,x,y);
        g.dispose();
        return img;
    }
    //Apply blur on image
    public static BufferedImage blurImage(BufferedImage img)
    {
        Kernel kernel = new Kernel(3, 3, new float[] { 0.0625f, 0.125f, 0.0625f, 0.125f, 0.25f, 0.125f,
                0.0625f, 0.125f, 0.0625f});
        BufferedImageOp op = new ConvolveOp(kernel);
        img = op.filter(img, null);
        return img;
    }
}


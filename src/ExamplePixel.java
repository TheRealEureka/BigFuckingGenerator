import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ExamplePixel {
    public static void main(String[] args)
    {
        int pixel_size =10;

        BufferedImage img ;

        try {
            img = ImageIO.read(new File("generated/Examples/PixelExample/oui.png"));



                ImageEditor.pixelMode(img, pixel_size);
                File f = new File("generated/Examples/PixelExample/Oui/pixel"+pixel_size+".png");
                ImageIO.write(img, "png", f);
              //  img = ImageIO.read(new File("generated/Examples/PixelExample/oui.png"));




        } catch (IOException e) {
        e.printStackTrace();
        }
    }
}

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ExamplePixel {
    public static void main(String[] args)
    {
        int pixel_size = 10;

        BufferedImage img ;
        try {
            img = ImageIO.read(new File("generated/Examples/PixelExample/input.png"));
            BigFuckingEditor.pixelMode(img, pixel_size);
            File f = new File("generated/Examples/PixelExample/output/pixel["+pixel_size+"].png");
            ImageIO.write(img, "png", f);
        } catch (IOException e) {
        e.printStackTrace();
        }
    }
}

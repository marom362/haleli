package unitTests;

import org.junit.Test;
import renderer.ImageWriter;

import java.awt.*;

/**
 * Test class ImageWriterTest
 * @author marom & haleli
 * test function writeToImage
 */
public class ImageWriterTest {
    /**
     *Test for producing a red color image with a blue grid.
     *  A grid of 10x16 squares on the screen,
     *  (ViewPlane) 1000 by 1600 and a resolution of 500 by 800.
     */
    @Test
    public void writeToImage()
    {
        ImageWriter image=new ImageWriter("test_image",1600,1000,800,500);

        for (int i = 0; i <image.getNx() ; i++)
        {
            for (int j = 0; j <image.getNy() ; j++)
            {
                 image.writePixel(i,j, Color.red);
                if (i % 50 == 0|| j % 50 == 0) {
                    image.writePixel(i, j, Color.BLUE);

                }

            }

        }
        image.writeToImage();

    }
}
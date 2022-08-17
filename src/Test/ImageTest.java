package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ImageTest
{
    @Test
    void Test01(){
        assertNotNull(new Object());
    }

    @Test
    void Test02(){
        BufferedImage image=null;
        try {
            image = ImageIO.read(new File("E:\\hc\\Test_tank2022\\src\\images\\bulletL.gif"));
            assertNotNull(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void Test03(){
        try {
            BufferedImage image = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
            assertNotNull(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

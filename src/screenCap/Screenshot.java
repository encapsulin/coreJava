package screenCap;// Java Program to Capture full
// Image of Screen
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class Screenshot {
    public static final long serialVersionUID = 1L;
    public static void main(String[] args)
    {
        try {
            givenComponent_whenTakeScreenshot_thenSaveToFile();
        }
        catch (Exception  ex) {
            System.out.println(ex);
        }
    }

    public static void givenMainScreen_whenTakeScreenshot_thenSaveToFile() throws Exception {
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage capture = new Robot().createScreenCapture(screenRect);

        File imageFile = new File("/tmp/single-screen.bmp");
        ImageIO.write(capture, "bmp", imageFile );
//        assertTrue(imageFile .exists());
    }

    public static void givenMultipleScreens_whenTakeScreenshot_thenSaveToFile() throws Exception {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] screens = ge.getScreenDevices();

        Rectangle allScreenBounds = new Rectangle();
        for (GraphicsDevice screen : screens) {
            Rectangle screenBounds = screen.getDefaultConfiguration().getBounds();
            allScreenBounds.width += screenBounds.width;
            allScreenBounds.height = Math.max(allScreenBounds.height, screenBounds.height);
        }

        BufferedImage capture = new Robot().createScreenCapture(allScreenBounds);
        File imageFile = new File("/tmp/all-screens.bmp");
        ImageIO.write(capture, "bmp", imageFile);
//        assertTrue(imageFile.exists());
    }

    public static void givenComponent_whenTakeScreenshot_thenSaveToFile() throws Exception {
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage capture = new Robot().createScreenCapture(screenRect);
        ImageIO.write(capture, "bmp", new File("/tmp/asdf.bmp"));
    }
}

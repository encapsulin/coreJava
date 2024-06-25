import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenCap {

    public static void main(String... args) {
        int iDelay = 10;
        if(args.length > 0)
            iDelay = Integer.parseInt(args[0]);

        System.out.printf("java Screen.java %d #seconds%n", iDelay);
        while(true) {
            String dir = FileManager.createDirs();
            screenCap(dir);
            FileManager.deleteOldDups(dir);
            try {
                Thread.sleep(iDelay*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void screenCap(String dir) {
        try {
            Robot robot = new Robot();
            Rectangle capture =
                    new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage Image = robot.createScreenCapture(capture);
            String path = dir + "/" + FileManager.fileNameNow();
            System.out.println(path);
            ImageIO.write(Image, "jpg", new File(path));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }




}
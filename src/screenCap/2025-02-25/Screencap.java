import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Screencap {

    public static void main(String... args) {
        try{
            Robot robot = new Robot();
            Rectangle capture =
                    new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage Image = robot.createScreenCapture(capture);
            String path = createDirs()+".jpg";
            System.out.println(path);
            ImageIO.write(Image, "jpg", new File(path));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String createDirs() {
        LocalDateTime ldt = LocalDateTime.now();
        String path = ldt.format(DateTimeFormatter.ofPattern("yyyy/MM/dd/"));
        File dir = new File(path);
        if(!dir.exists())
            dir.mkdirs();

        path += ldt.format(DateTimeFormatter.ofPattern("HH-mm-ss"));
        return path;
    }

}
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FileManager {

    public static void main(String[] args) {
        String dir = "2024/06/24/";
//        var out = getSortedFilesByModificationDate(dir);
        var out = deleteOldDups(dir);
        System.out.println(out);
    }

    public static SortedSet<FileItem> getSortedFilesByModificationDate(String dir) {
        Comparator<FileItem> cmp = (o1, o2) -> o2.fn.compareTo(o1.fn);
        TreeSet<FileItem> files = new TreeSet<>(cmp);

        Path startDir = Paths.get(dir);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(startDir)) {
            for (Path entry : stream) {
                if (Files.isRegularFile(entry)) {
                    var file = new FileItem(entry.getFileName().toString(), Files.size(entry));
                    files.add(file);
                }
            }

            return files;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return files;
    }

    public static Boolean deleteOldDups(String dir) {
        var files = FileManager.getSortedFilesByModificationDate(dir);
        //System.out.println(files);
        if (files.size() < 3)
            return false;

        List<FileItem> list = new ArrayList<>(files);
        if (list.get(1).fs.equals(list.get(0).fs) && list.get(1).fs.equals(list.get(2).fs)) {
            try {
                String fn = dir + "/" + list.get(1).fn;
                System.out.println("Delete dup: " + fn);
                Files.delete(Paths.get(fn));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return true;
    }

    public static String createDirs() {
        LocalDateTime ldt = LocalDateTime.now();
        String path = ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd/"));
        File dir = new File(path);
        if (!dir.exists())
            dir.mkdirs();

        return dir.getPath();
    }

    public static String fileNameNow(){
        LocalDateTime ldt = LocalDateTime.now();
        return ldt.format(DateTimeFormatter.ofPattern("HH-mm-ss")) + ".jpg";
    }
}


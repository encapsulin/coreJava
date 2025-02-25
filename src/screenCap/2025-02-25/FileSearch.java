import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class FileSearch {

    public static void main(String[] args) {
        LinkedHashMap<String, Integer> sortedFiles = getSortedFilesByModificationDate("your/directory/path");
        sortedFiles.forEach((name, size) -> System.out.println("File: " + name + ", Size: " + size + " bytes"));
    }

    public static LinkedHashMap<String, Integer> getSortedFilesByModificationDate(String dir) {
        Path startDir = Paths.get(dir);
        List<Path> files = new ArrayList<>();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(startDir)) {
            for (Path entry : stream) {
                if (Files.isRegularFile(entry)) {
                    files.add(entry);
                }
            }

            // Sort files by last modified time in descending order
            files.sort((f1, f2) -> {
                try {
                    return Files.getLastModifiedTime(f2).compareTo(Files.getLastModifiedTime(f1));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            // Create a LinkedHashMap to preserve the order
            LinkedHashMap<String, Integer> sortedFiles = new LinkedHashMap<>();
            for (Path file : files) {
                sortedFiles.put(file.getFileName().toString(), (int) Files.size(file));
            }

            return sortedFiles;

        } catch (IOException e) {
            e.printStackTrace();
            return new LinkedHashMap<>(); // Return an empty map in case of an error
        }
    }
}

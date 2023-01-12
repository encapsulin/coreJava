package demo.collections;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.Locale;

public class MainFiles {
    public static void main(String[] args) throws IOException {
        System.out.println("-=start=-");
        System.out.println(solution("fn.txt"));
        System.out.println("-=start=-");
    }

    public static String solution(String fn) throws IOException {
        System.out.println("solution()");
        return new String(Files.readAllBytes(Paths.get(fn)));
    }
}
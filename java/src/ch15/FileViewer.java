package ch15;

import java.io.FileInputStream;
import java.io.IOException;

public class FileViewer {
    public static void execute(String... args) {
        if (1 != args.length) {
            System.err.println("Input file name");
            return;
        }

        try (
                FileInputStream fis = new FileInputStream(args[0]);) {
            int data = 0;
            while ((data = fis.read()) != -1) {
                char c = (char) data;
                System.out.print(c);
            }
        } catch (IOException e) {

        }
    }
}

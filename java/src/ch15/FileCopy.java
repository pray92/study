package ch15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void execute(String... args) {
        if (2 != args.length) {
            System.err.println("Format : [src for copy] [file to copy]");
            return;
        }
        try (
                FileInputStream fis = new FileInputStream(args[0]);
                FileOutputStream fos = new FileOutputStream(args[1]);
        ) {
            int data = 0;
            while((data = fis.read()) != -1){
                fos.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

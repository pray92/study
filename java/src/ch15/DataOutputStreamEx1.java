package ch15;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamEx1 {
    public static void execute() {
        try (
            FileOutputStream fos = new FileOutputStream("sample.data");
            DataOutputStream dos = new DataOutputStream(fos);
        ){
            dos.writeInt(10);
            dos.writeFloat(20.f);
            dos.writeBoolean(true);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}

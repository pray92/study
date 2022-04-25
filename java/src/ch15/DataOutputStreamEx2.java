package ch15;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class DataOutputStreamEx2 {
    public static void execute() {

        try (
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                DataOutputStream dos = new DataOutputStream(bos)
        ) {
            byte[] result = null;

            dos.writeInt(10);
            dos.writeFloat(20.f);
            dos.writeBoolean(true);

            result = bos.toByteArray();

            String[] hex = new String[result.length];

            for(int i = 0; i < result.length; ++i) {
                if(result[i] < 0){
                    hex[i] = String.format("%02x", result[i] + 256);
                } else {
                    hex[i] = String.format("%02x", result[i]);
                }
            }

            System.out.println("10 진수 : " + Arrays.toString(result));
            System.out.println("16 진수 : " + Arrays.toString(hex));
        } catch (IOException e) {

        }
    }
}

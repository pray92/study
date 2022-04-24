package ch15;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamEx1 {
    public static void execute(){
        try {
            FileOutputStream fos = new FileOutputStream("123.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos, 5);
            for(int i = '1'; i <= '9'; ++i){
                bos.write(i);
            }
            // fos.close();    // 이러면 버퍼가 close 되지 않아 남아 있게 됨
            bos.close();        // 알아서 fos도 close해주기 때문에 이를 권장
        } catch (IOException e){

        }
    }
}

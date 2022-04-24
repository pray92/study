package ch15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class IOEx4 {

    public static void execute() {
        byte[] inSrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        byte[] outSrc = null;
        byte[] temp = new byte[4];

        ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        System.out.println("Input Source : " + Arrays.toString(inSrc));

        try {
            while (0 < input.available()) {
                // 불러오는 과정에서 버퍼에 남아 있는 값이 들어오는 것을 확인
                // 이는 temp에 담긴 내용을 지우고 쓰는 것이 아닌 기존의 내용 위에 덮어쓰기 때문
                // input.read(temp);
                // output.write(temp);
                // outSrc = output.toByteArray();
                
                // 따라서 아래와 같이 처리해요
                int len = input.read(temp); // 읽어온 데이터 개수 반환
                output.write(temp, 0, len);
            }

            outSrc = output.toByteArray();
        } catch (IOException e) {
        } finally {
            System.out.println("temp          :" + Arrays.toString(temp));
            System.out.println("Output Source :" + Arrays.toString(outSrc));
        }
    }
}

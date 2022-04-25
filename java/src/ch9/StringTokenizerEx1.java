package ch9;

import java.util.StringTokenizer;

public class StringTokenizerEx1 {
    public static void execute() {

        StringTokenizer st = new StringTokenizer("100,200,300,400", ",");
        
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
    }
}

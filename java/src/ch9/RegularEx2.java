package ch9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx2 {
    public static void execute() {
        String[] data = {
            "bat", "baby", "bonus", "c", "cA", "ca", "co",
            "c.", "c0", "c#", "car", "combat", "count", "date", "disc"
        };

        // 역슬래쉬는 두번 쳐야 인식되요
        String[] pattern = {
            ".*", "c[a-z]*", "c[a-z]", "c[a-zA-Z]",
            "c[a-zA-Z0-9]", "c.", "c.*", "c\\.", "c\\w", "c\\d",
            "c.*t", "[b|c]", ".*a.+", "[b|c].{2}"
        };

        for(int x = 0; x < pattern.length; ++x){
            Pattern p = Pattern.compile(pattern[x]);
            System.out.print("Pattern : " + pattern[x] + ", 결과 : ");
            for(int i = 0 ; i < data.length; ++i){
                if(p.matcher(data[i]).matches()){
                    System.out.print(data[i] + ", ");
                }
            }
            System.out.println();
        }
    }
}

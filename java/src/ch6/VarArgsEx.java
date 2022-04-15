package ch6;

public class VarArgsEx {
    public static void execute() {
        String[] strArr = { "100", "200", "300" };
        
        System.out.println(concatenate("", "100", "200", "300" ));
        System.out.println(concatenate("-", strArr));
        System.out.println(concatenate(",", new String[] {"1", "2", "3"}));
        System.out.println("[" + concatenate(",", new String[0]) + "]");
        System.out.println("[" + concatenate(",") + "]");

        // 도중에 배열 -> 단일 변수 안됨
        //System.out.println(concatenate(",", new String[] {"1", "2", "3"}, "100", "200"));
        // 도중에 단일 변수 -> 배열 안됨
        //System.out.println(concatenate(",", "100", "200", new String[] {"1", "2", "3"}));
    }

    private static String concatenate(String delim, String... args){
        StringBuilder sb = new StringBuilder();
        for(String str : args) { sb.append(str + delim); }
        if(0 < sb.length() && false == delim.isEmpty()){
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}

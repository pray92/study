
import java.util.Iterator;

import com.google.common.base.Splitter;
import com.packages.Util;

public class GuavaTest {
    public static void main(String[] args) {
        guavaSplit();
        Util.printHelloWorld();
    }

    public static void guavaSplit(){
        try{
            String fruits = "사과딸기레몬포도";
            Iterable<String> split = Splitter.fixedLength(2).split(fruits);  //2자 단위로 split
            
            Iterator<String> iterator = split.iterator();
            
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

        } catch (NoClassDefFoundError ex){
            ex.printStackTrace();
        }
    }
}

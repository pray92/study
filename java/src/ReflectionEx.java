import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionEx {
    public static void execute() {
        try{
            Object app = new App();
            Class appClass= App.class;
            Method appMethod = appClass.getDeclaredMethod("privateAdd", int.class, int.class);
            appMethod.setAccessible(true);
            System.out.println((int)appMethod.invoke(app, 1, 2));
        } catch(NoSuchMethodException e){
            e.printStackTrace();
        } catch(SecurityException e) {
            e.printStackTrace();
        } catch(InvocationTargetException e) {
            e.printStackTrace();
        } catch(IllegalAccessException e) {
            e.printStackTrace();
        }
    }   
}

class App {
    private int privateAdd(int a, int b){
        return a + b;
    }
}

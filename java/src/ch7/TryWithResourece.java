package ch7;

public class TryWithResourece {

    public static void execute() {
        try (CloseableResources cr = new CloseableResources()) {
            cr.exceptionWork(false);        // 예외 발생하지 않아요
        } catch (WorkExeption e) {
            e.printStackTrace();
        } catch (CloseExecption e) {
            e.printStackTrace();
        }
         System.out.println();
         try (CloseableResources cr = new CloseableResources()) {
             cr.exceptionWork(true);        // 예외 발생해요
         } catch (WorkExeption e) {
             e.printStackTrace();
         } catch (CloseExecption e) {
             e.printStackTrace();
         }
    }
}

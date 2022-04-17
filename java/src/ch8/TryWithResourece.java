package ch8;

public class TryWithResourece {

    public static void execute() {
        try (CloseableResources cr = new CloseableResources()) {
            cr.exceptionWork(false);        // 예외 발생하지 않아요
        } catch (WorkException e) {
            e.printStackTrace();
        } catch (CloseException e) {
            e.printStackTrace();
        }
         System.out.println();
         try (CloseableResources cr = new CloseableResources()) {
             cr.exceptionWork(true);        // 예외 발생해요
         } catch (WorkException e) {
             e.printStackTrace();
         } catch (CloseException e) {
             e.printStackTrace();
         }
    }
}

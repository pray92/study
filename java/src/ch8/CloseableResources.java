package ch8;

public class CloseableResources implements AutoCloseable{
    
    public void exceptionWork(boolean exception) throws WorkException {
        System.out.println("exceptionWork(" + exception + ")가 호출되었어요");
        if(exception){
            throw new WorkException("WorkException 발생!");
        }
    }

    @Override 
    public void close() throws CloseException {
        System.out.println("close() 호출");
        throw new CloseException("CloseExecption 발생!");
    }
}

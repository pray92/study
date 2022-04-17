package ch7;

public class CloseableResources implements AutoCloseable{
    
    public void exceptionWork(boolean exception) throws WorkExeption {
        System.out.println("exceptionWork(" + exception + ")가 호출되었어요");
        if(exception){
            throw new WorkExeption("WorkException 발생!");
        }
    }

    @Override 
    public void close() throws CloseExecption {
        System.out.println("close() 호출");
        throw new CloseExecption("CloseExecption 발생!");
    }
}

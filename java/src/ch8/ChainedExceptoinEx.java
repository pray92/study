package ch8;

public class ChainedExceptoinEx {
    public static void execute() {
        try {
            install();
        } catch(InstallException e){
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private static void install() throws InstallException {
        try {
            startInstall();
            copyFiles();
        } catch(SpaceException se) {
            InstallException ie = new InstallException("설치 중 예외 발생");
            ie.initCause(se);
            throw ie;
        } catch (MemoryException me ) {
            InstallException ie = new InstallException("설치 중 예외 발생");
            ie.initCause(me);
            throw ie;   
        } finally {
            deleteTempFiles();      // 설치에 사용된 임시 파일들 삭제
        }
    }
    
    private static void startInstall() throws SpaceException, MemoryException {
        if(!enoughSpace()) {
            throw new SpaceException("설치할 공간이 부족해요.");
        }
        if(!enoughMemory()){
            throw new MemoryException("메모리가 부족해요.");
            //throw new RuntimeException(new MemoryException("메모리가 부족해요."));
        }
    }

    private static void copyFiles() {
        System.out.println("파일을 복사해요");
    }

    private static void deleteTempFiles() {
        System.out.println("임시 파일을 삭제해요");
    }

    private static boolean enoughSpace() {
        return true;
    }

    private static boolean enoughMemory() {
        return false;
    }
}

class InstallException extends Exception {
    InstallException(String msg){
        super(msg);
    }
}

class SpaceException extends Exception {
    SpaceException(String msg){
        super(msg);
    }
}

class MemoryException extends Exception {
    MemoryException(String msg){
        super(msg);
    }
}



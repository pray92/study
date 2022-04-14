package ch6;

public class TvText {

    public static void execute() {
        Tv t; // Tv 인스턴스 참조하기 위한 변수 t 선언
        t = new Tv(); // Tv 인스턴스를 생성
        t.channel = 7; // Tv 인스턴스의 멤버변수 channel 값을 7로 초기화
        t.channelDown(); // Tv 인스턴스의 메서드 channelDown() 호출
        System.out.println("현재 채널은 " + t.channel + "입니다.");
    }
}

package ch12;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
@SuppressWarnings("1111")   // 유효하지 않은 애너테이션 무시
@TestInfo(testedBy = "Vic", testDate=@DateTime(yymmdd = "220503", hhmmss = "235959"))
public class AnnotationEx5 {
    public static void execute() {
        // 객체를 얻어와요
        Class<AnnotationEx5> clazz = AnnotationEx5.class;
        
        TestInfo anno = (TestInfo)clazz.getAnnotation(TestInfo.class);
        System.out.println("anno.testedBy() : " + anno.testedBy());
        System.out.println("anno.testDate().yymmdd() : " + anno.testDate().yymmdd());
        System.out.println("anno.testDate().yymmdd() : " + anno.testDate().hhmmss());

        for(String str : anno.testTools()){
            System.out.println("testTools : " + str);
        }
        System.out.println();

        // 적용된 모든 애너테이션을 가져와요
        Annotation[] annoArr = clazz.getAnnotations();
        for(Annotation a : annoArr){
            System.out.println(a);
        }
    }
}

@Retention(RetentionPolicy.RUNTIME) // 실행 시 사용가능하도록 지정
@interface TestInfo {
    int count() default  1;
    String testedBy();
    String[] testTools() default "JUnit";
    TestType testType() default TestType.FIRST;
    DateTime testDate(); 
}

enum TestType { FIRST, FINAL }

@Retention(RetentionPolicy.RUNTIME)
@interface DateTime {
    String yymmdd();
    String hhmmss();
}
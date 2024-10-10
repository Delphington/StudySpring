package ico.dependency_injection.Onlyannotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );

        PlayerMusic playerMusic= context.getBean("playerMusic", PlayerMusic.class);
        System.out.println(playerMusic.getMusic());
    }
}

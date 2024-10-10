package ico.dependency_injection.AnotationValue;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        PlayerMusic playerMusic = context.getBean("playerMusic", PlayerMusic.class);
        System.out.println(playerMusic.getTime());
        //Именно после этого вызывится destroy
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                context.close();
            }});
    }
}

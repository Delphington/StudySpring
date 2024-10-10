package ico.dependency_injection.Qualifier;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        PlayerMusic playerMusic = context.getBean("playerMusic", PlayerMusic.class);

        System.out.println(playerMusic.music.getSong()); //rock
        System.out.println(playerMusic.getMusic());

    }
}

package ico.dependency_injection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );
        //TODO: Проблема, что мы в ручную создаем объекты - можно это автоматизировать
        Music music= context.getBean("ClassicMusic", ClassicMusic.class); //полиморфизм

        PlayerMusic pl = new PlayerMusic(music);
        System.out.println(pl.getMusic()); // классическая ClassicMusic

//        TestBean  testBean = context.getBean("testBean", TestBean.class);
//        System.out.println(testBean.getName());
//        context.close();
    }
}

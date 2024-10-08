package ico.dependency_injection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );
        //TODO: Проблема, что мы в ручную создаем объекты - можно это автоматизировать
        /**
         Music music= context.getBean("ClassicMusic", ClassicMusic.class); //полиморфизм
         PlayerMusic pl = new PlayerMusic(music);
         System.out.println(pl.getMusic()); // классическая ClassicMusic
         */

        //# Решение: (подключаем  зависимости в applicationContext)
        //Передаем в параметры: id - нашего Бина, и возвращаемый тип
//        PlayerMusic playerMusic = context.getBean("PlayerMusic", PlayerMusic.class);
//        System.out.println(playerMusic.getMusic());  // классическая ClassicMusic

        //Альтернатива: внедрение через setter
        //Spring создает объект через пустой конструктор и вызывает метод Setter
        PlayerMusic playerMusic = context.getBean("PlayerMusic", PlayerMusic.class);
        System.out.println(playerMusic.getMusic());  // классическая ClassicMusic
        System.out.println(playerMusic.getTime());  // классическая ClassicMusic

        //--------------------------------------------------
        //Дефолтный паттерн
        PlayerMusic playerMusic1 = context.getBean("PlayerMusic", PlayerMusic.class);
        PlayerMusic playerMusic2 = context.getBean("PlayerMusic", PlayerMusic.class);
        System.out.println(playerMusic1==playerMusic2); //true
        // {меняем: class="ico.dependency_injection.PlayerMusic"
        //          scope="prototype"} ->  false


    }
}

package ico.dependency_injection.Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
class Dog{
    String name;
    public String getName(){return name;}

    public Dog(String name) {
        this.name = name;
    }
}


@Component
class Capy{

    private  Dog dog;

    @Autowired
    public Capy(Dog dog) {
        this.dog = dog;
    }

    public Dog getDog() {
        return dog;
    }

    String name = "Hello";
    public String getName() { return name; }
}


public class Annotation {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
        "applicationContext.xml");
        Capy capy = context.getBean("capy", Capy.class);
    }
}

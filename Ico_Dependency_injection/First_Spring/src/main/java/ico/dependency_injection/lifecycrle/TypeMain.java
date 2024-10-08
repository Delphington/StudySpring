package ico.dependency_injection.lifecycrle;

import org.springframework.context.support.ClassPathXmlApplicationContext;



 class Life {
    private String name = "d";
    private Life(){}

    public static Life MyFactory(){
        return new Life();
    }


    public void MyInitMethod(){
        System.out.println("MyInitMethod");

    }
    public void MyDestroyedMethod(){
        System.out.println("DestroyedMethod");
    }
}


public class TypeMain {
    public static void main(String[] args) {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                    "applicationContext.xml"
            );
            Life life = context.getBean("lifeC", Life.class);
    }
}

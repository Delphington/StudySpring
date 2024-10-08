package ico.dependency_injection.lifecycrle.factoryMethod;

class Coffee {
    public void grindCoffee() {
        // перемалываем кофе
    }

    public void makeCoffee() {
        // делаем кофе
    }

    public void pourIntoCup() {
        // наливаем в чашку
    }
}

class Americano extends Coffee {
}

class Cappuccino extends Coffee {
}

class CaffeLatte extends Coffee {
}

class Espresso extends Coffee {
}

enum CoffeeType {
    ESPRESSO,
    AMERICANO,
    CAFFE_LATTE,
    CAPPUCCINO
}

class SimpleCoffeeFactory {
    public Coffee createCoffee (CoffeeType type) {
        Coffee coffee = null;

        switch (type) {
            case AMERICANO:
                coffee = new Americano();
                break;
            case ESPRESSO:
                coffee = new Espresso();
                break;
            case CAPPUCCINO:
                coffee = new Cappuccino();
                break;
            case CAFFE_LATTE:
                coffee = new CaffeLatte();
                break;
        }

        return coffee;
    }
}

//сама кофейня
class CoffeeShop {

    private final SimpleCoffeeFactory coffeeFactory;

    public CoffeeShop(SimpleCoffeeFactory coffeeFactory) {
        this.coffeeFactory = coffeeFactory;
    }

    public Coffee orderCoffee(CoffeeType type) {
        Coffee coffee = coffeeFactory.createCoffee(type);
        coffee.grindCoffee();
        coffee.makeCoffee();
        coffee.pourIntoCup();

        System.out.println("Вот ваш кофе! Спасибо, приходите еще!");
        return coffee;
    }
}




public class factory {
    public static void main(String[] args) {

    }
}

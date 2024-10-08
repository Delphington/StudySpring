package ico.dependency_injection;

public class RegularExpression {

    /**\
     \\ - обозначения спецеального символа
     \\d - только одна цифра
     \\w - одна буква
     \\d+ - один или более цифр
     \\d- - ноль или более wbah
     \\d

     + - один или более цифр
     - - ноль или более цифр
     ? - до него символ может быть или не быть

     ( | | ) - множетсво возможных случаев
     w[a-zA-Z] - все английские буквы
     [] - большие множества
     [abc] -> (a|b|c)
     [a-zA-Z] - все английские буквы
     [0-9] -> \\d - все цифры

     [^abc] -> Хотим все символы кроме а б с

     . - любой символ

     Альтернатива *
     {2} - два символа до {\\d{2}} - 2 цифры хотим
     {2, } - два и более символа
     {2, 4} - от двух до четырех символов
    */
    public static void main(String[] args) {
        String a = "danial";
        System.out.println(a.matches(a));//Сравнение строк, возвращает bool
        System.out.println(a.matches("gf") + "======"); //false


        String test = "1da";
        System.out.println(test.matches("\\d")); //test = "1" ->true, test="31" ->false
        System.out.println(test.matches("\\d+")); //test = "1" ->true, test="31" ->true

        String c1;
        test = "-4141";
        System.out.println(test.matches("\\d+")); //false
        System.out.println(test.matches("-\\d+")); //true


        String a1 = "-4141";
        String b1 = "4141"; // может быть символ перед ? а может не быть
        System.out.println(a1.matches("-?\\d+")); //true
        System.out.println(b1.matches("-?\\d+")); //true

        //Чтобы подходили все 3
        a1 = "1234";
        b1 = "-1234";
        c1 = "+1234";
        System.out.println(a1.matches("(\\+|-)?\\d+")); //true
        System.out.println(b1.matches("(\\+|-)?\\d+")); //true
        System.out.println(c1.matches("(\\+|-)?\\d+")); //true

        //Всегда до строки есть буква
        a1 = "a4141";
        System.out.println(a1.matches("[a-zA-Z]?\\d+")); //true

        //Если мно буквы
        a1 = "dandqiwdq4141"; // '+' - средний, показывает, что это до набора цифр
        System.out.println(a1.matches("[a-zA-Z]+\\d+")); //true


        a1 = "dandq54iwdq4141";
        System.out.println(a1.matches("[a-zA-Z45]+\\d+")); //true


        a1 = "anb21";
        System.out.println(a1.matches("[^a]+\\d+")); //false


        a1 = "googel.com";
        System.out.println(a1.matches("googel\\..+")); //true
    }
}

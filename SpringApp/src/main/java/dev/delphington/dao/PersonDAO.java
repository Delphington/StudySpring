package dev.delphington.dao;

import dev.delphington.models.Person;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;

@Component
//Класс для общение с БД
public class PersonDAO {
    private static int peopleCount = 1;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(peopleCount++, "Tom"));
        people.add(new Person(peopleCount++, "Bob"));
        people.add(new Person(peopleCount++, "Mike"));
        people.add(new Person(peopleCount++, "Katy"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }


}

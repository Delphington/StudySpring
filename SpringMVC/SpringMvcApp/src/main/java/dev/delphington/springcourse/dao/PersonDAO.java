package dev.delphington.springcourse.dao;

import dev.delphington.springcourse.models.Person;
import dev.delphington.springcourse.repositories.PeopleRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class PersonDAO {

    private final EntityManager entityManager;

    @Autowired
    public PersonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Transactional(readOnly = true)
    public void testNPlu1() {
        Session session = entityManager.unwrap(Session.class);

//        //Запрос 1: все люди
//        List<Person> listPerson =
//                session.createQuery("SELECT p FROM Person  p", Person.class)
//                        .getResultList();
//
//        //N к бд
//        for (Person person : listPerson) {
//            System.out.println("Person " + person.getName() + " " + person.getItems());
//        }

        List<Person> people = session
                .createQuery("SELECT p FROM Person p LEFT JOIN FETCH p.items", Person.class)
                .getResultList();

        //N к бд
        for (Person person : people) {
            System.out.println("Person " + person.getName() + " " + person.getItems());
        }

    }

}

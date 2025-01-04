package dev.delphington.springcourse.dao;

import dev.delphington.springcourse.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class PersonDAO {

    @Autowired
    private final SessionFactory sessionFactory = null;

    @Transactional(readOnly = true)
    public List<Person> index() {
        Session session = sessionFactory.getCurrentSession();
        List<Person> people =
                session.createQuery("SELECT p FROM Person p", Person.class)
                        .getResultList();
        return people;
    }

    @Transactional(readOnly = true)
    public Person show(int id) {
        return sessionFactory.getCurrentSession().get(Person.class, id);
    }

    @Transactional
    public void save(Person person) {
        sessionFactory.getCurrentSession().persist(person);

    }

    @Transactional
    public void update(int id, Person updatedPerson) {
        Session session= sessionFactory.getCurrentSession();
        Person person =  session.get(Person.class, id);
        person.setName(updatedPerson.getName());
        person.setAge(updatedPerson.getAge());
        person.setEmail(updatedPerson.getEmail());
    }

    @Transactional
    public void delete(int id) {
        sessionFactory.getCurrentSession()
                .remove(sessionFactory.getCurrentSession().get(Person.class, id));


    }
}

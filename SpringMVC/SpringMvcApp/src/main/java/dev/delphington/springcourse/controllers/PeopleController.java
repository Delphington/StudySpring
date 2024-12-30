package dev.delphington.springcourse.controllers;

import dev.delphington.springcourse.dao.PersonDAO;
import dev.delphington.springcourse.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model) {
        // Получим всех людей из DAO и отобразим
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }


    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        // Получим человека по id
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person){
        //Вводим данные для человека
        return "people/new";
    }

    @PostMapping
    public String create(@ModelAttribute("person") Person person){
        //В person - пришли заполненные данные с формы
        personDAO.save(person);
        //Сохраняем данные в бд
        return "redirect:/people";
    }
}
package dev.delphington.springcourse.controllers;

import dev.delphington.springcourse.models.Person;
import dev.delphington.springcourse.services.ItemService;
import dev.delphington.springcourse.services.PeopleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private final PeopleService peopleService;

    @Autowired
    private final ItemService itemService;

    public PeopleController(PeopleService peopleService, ItemService itemService) {
        this.peopleService = peopleService;
        this.itemService = itemService;
    }


    @GetMapping()
    public String index(Model model) {
        // Получим всех людей из DAO и отобразим
        model.addAttribute("people", peopleService.findAll());
        itemService.findByName("TV");
        itemService.findByOwner(peopleService.findAll().get(0));

        peopleService.test();
        return "people/index";
    }


    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        // Получим человека по id
        model.addAttribute("person", peopleService.findOne(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        //Вводим данные для человека
        return "people/new";
    }

    @PostMapping
    public String create(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "people/new"; //возвращаем туже самую форму
            //но ошибки будут показываться с помощью таймлифа
        }

        //В person - пришли заполненные данные с формы
        peopleService.save(person);
        //Сохраняем данные в бд
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", peopleService.findOne(id));
        return "people/edit";
    }


    @PostMapping("/{id}")
    public String update(@ModelAttribute("person") Person person, @PathVariable("id") int id) {
        peopleService.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        peopleService.delete(id);
        return "redirect:/people";
    }

}
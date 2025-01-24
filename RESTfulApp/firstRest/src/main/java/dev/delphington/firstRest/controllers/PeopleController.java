package dev.delphington.firstRest.controllers;

import dev.delphington.firstRest.dto.PersonDTO;
import dev.delphington.firstRest.models.Person;
import dev.delphington.firstRest.services.PersonService;
import dev.delphington.firstRest.util.PersonErrorResponse;
import dev.delphington.firstRest.util.PersonNotCreatedException;
import dev.delphington.firstRest.util.PersonNotFoundException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {
    private final PersonService personService;
    private final ModelMapper modelMapper;

    @Autowired
    public PeopleController(PersonService personService, ModelMapper modelMapper) {
        this.personService = personService;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    public List<PersonDTO> getPeople() {
        return personService.findAll().stream().map(this::convertToPersonDTO).toList();
    }

    @GetMapping("{id}")
    public PersonDTO getPerson(@PathVariable("id") int id) {
        return convertToPersonDTO(personService.findOne(id));
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid PersonDTO personDTO,
                                             BindingResult bindingResult) {
        //Клиент прислал не валидного человека
        if (bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                errorMsg.append(error.getField())
                        .append(" - ").append(error.getDefaultMessage())
                        .append(";");

            }
            throw new PersonNotCreatedException(errorMsg.toString());
        }
        personService.save(convertToPerson(personDTO));
        //Отправляем HTTP ответ с пустым телом и со статусом 200
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private Person convertToPerson(PersonDTO personDTO) {
        return modelMapper.map(personDTO, Person.class);
    }

    private PersonDTO convertToPersonDTO(Person person) {
        return modelMapper.map(person, PersonDTO.class);
    }


    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handleException(PersonNotCreatedException e) {
        PersonErrorResponse response = new PersonErrorResponse(e.getMessage(), System.currentTimeMillis());
        // В HTTP ответе тело ответа (response) и статус в заголовке
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handleException(PersonNotFoundException e) {
        PersonErrorResponse response = new PersonErrorResponse("Person with this id wasn't found",
                System.currentTimeMillis());
        // В HTTP ответе тело ответа (response) и статус в заголовке
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); // 404 - статус
    }


}

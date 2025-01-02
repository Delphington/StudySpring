package dev.delphington.springcourse.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Person {
    private int id;
    @NotEmpty(message =  "Name should not be empty")
    @Size(min =2, max = 30, message = "Warning")
    private String name;
}

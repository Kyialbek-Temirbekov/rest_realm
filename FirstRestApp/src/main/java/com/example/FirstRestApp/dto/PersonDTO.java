package com.example.FirstRestApp.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class PersonDTO {
    @NotEmpty(message = "name should not be empty")
    @Size(min=1, max=30, message = "name should be between 1 and 30 characters")
    private String name;
    @Min(value = 0, message = "age should be greater than 0")
    private int age;
    @NotEmpty(message = "email should not be empty")
    @Email(message = "email should be valid")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

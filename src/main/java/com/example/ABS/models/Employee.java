package com.example.ABS.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table (name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Фамилия не может быть пустой")
    private String lastName;

    @NotBlank(message = "Имя не может быть пустым")
    private String firstName;

    @NotBlank(message = "Отчество не может быть пустым")
    private String middleName;

    @NotBlank(message = "Номер телефона не может быть пустым")
    @Pattern(regexp = "\\+?[0-9]{10,15}", message = "Некорректный номер телефона")
    private String phoneNumber;

    @Email(message = "Некорректный адрес электронной почты")
    @NotBlank(message = "Email не может быть пустым")
    private String email;

    @NotBlank(message = "Страна не может быть пустой")
    private String country;

    @NotBlank(message = "Город не может быть пустым")
    private String city;
}

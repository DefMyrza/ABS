package com.example.ABS.controller;

import com.example.ABS.models.Employee;
import com.example.ABS.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class EmployeeController {

    // Подключаем репозиторий для работы с БД
    @Autowired
    private EmployeeRepository employeeRepository;

    // Метод для отображения всех сотрудников
    @GetMapping("/")
    public String employees(Model model) {
        // Получаем список всех сотрудников из БД через репозиторий
        model.addAttribute("employees", employeeRepository.findAll());
        return "employees"; // Возвращаем HTML-шаблон employees.ftlh
    }

    // Метод для добавления нового сотрудника
    @PostMapping("/add")
    public String addEmployee(@Valid @ModelAttribute Employee employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("employee", employee);
            return "add-employee";
        }
        employeeRepository.save(employee);
        return "redirect:/";
    }
}
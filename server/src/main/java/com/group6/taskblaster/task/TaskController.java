package com.group6.taskblaster.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    
    @Autowired
    private TaskRepository repository;

    @CrossOrigin(origins = "http://localhost:3000" )
    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return repository.findAll();
    }
}
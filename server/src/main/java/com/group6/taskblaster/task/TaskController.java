package com.group6.taskblaster.task;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// allow access to our React Node server running on port 3000
@CrossOrigin(origins = "http://localhost:3000" )
@RestController
public class TaskController {
    
    @Autowired
    private TaskRepository repository;

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    @PostMapping("/addtask")
    public void postTask(@RequestBody Task task) {
        repository.save(task);
        // Task postedTask = repository.save(task);
        // URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path()
    }
}
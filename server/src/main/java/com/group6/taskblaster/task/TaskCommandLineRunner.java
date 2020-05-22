package com.group6.taskblaster.task;

import java.util.Date;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TaskCommandLineRunner implements CommandLineRunner {
    
    private final TaskRepository repository;

    public TaskCommandLineRunner(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String ... strings) throws Exception {
        Task t1 = new Task("Title1", new Date());
        Task t2 = new Task("Title2", new Date());
        System.out.println(t1.getId());
        System.out.println(t1.toString());
        System.out.println(t2.getId());
        System.out.println(t2.toString());
        repository.save(t1);
        repository.save(t2);
    }
}

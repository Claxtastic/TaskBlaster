package com.group6.taskblaster.task;

import java.util.ArrayList;
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
        ArrayList<String> subtasks = new ArrayList<String>();
        subtasks.add("sub1");
        subtasks.add("sub2");
        Task t1 = new Task("Title1", subtasks, new Date());
        Task t2 = new Task("Title2", subtasks, new Date());
        repository.save(t1);
        repository.save(t2);
    }
}

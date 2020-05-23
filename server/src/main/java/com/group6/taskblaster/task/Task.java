package com.group6.taskblaster.task;

import java.util.Date;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @ElementCollection(targetClass=String.class)
    private List<String> subTasks;

    private String dueDate;

    public Task() { }

    public Task(String title, List<String> subTasks, String dueDate) {
        this.title = title;
        this.subTasks = subTasks;
        this.dueDate = dueDate;
    }

    public long getId() { return this.id; }
    public String getTitle() { return this.title; }
    public List<String> getSubTasks() { return subTasks; }
    public String getDueDate() { return this.dueDate; }

    public void setId(final long id) { this.id = id; }
    public void setTitle(final String title) { this.title = title; }
    public void setSubTasks(final List<String> subTasks) { this.subTasks = subTasks; }
    public void setDueDate(final String date) { this.dueDate = date; }

    @Override
    public String toString() {
        return "Task(" + this.title + ")";
    }
}

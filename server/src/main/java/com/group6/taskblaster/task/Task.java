package com.group6.taskblaster.task;

import java.util.Date;
import java.util.List;
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
    // private List<String> subtasks;
    private Date dueDate;

    public Task() { }

    public Task(String title, Date dueDate) {
        this.title = title;
        // this.subtasks = subtasks;
        this.dueDate = dueDate;
    }

    public long getId() { return this.id; }
    public String getTitle() { return this.title; }
    // public List<String> getSubtasks() { return subtasks; }
    public Date getDueDate() { return this.dueDate; }

    public void setId(final long id) { this.id = id; }
    public void setTitle(final String title) { this.title = title; }
    // public void setSubttasks(final List<String> subtasks) { this.subtasks = subtasks; }
    public void setDueDate(final Date date) { this.dueDate = date; }

    @Override
    public String toString() {
        return "Task(" + this.title + ")";
    }
}

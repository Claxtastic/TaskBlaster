package com.group6.taskblaster.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface TaskRepository extends JpaRepository<Task, Long> { }
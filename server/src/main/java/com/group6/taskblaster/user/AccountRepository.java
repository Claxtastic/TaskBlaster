package com.group6.taskblaster.user;

import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface AccountRepository extends Repository<Account, Long> {
    
    Account save(Account user);

    Account findByName(String name);
}
package com.springboot.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.model.User;

public interface UserReository extends CrudRepository<User, Integer> {

}

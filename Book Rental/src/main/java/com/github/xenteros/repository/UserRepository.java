package com.github.xenteros.repository;

import com.github.xenteros.security.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findOneByLogin(String login);

}

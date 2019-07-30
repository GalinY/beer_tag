package com.beerdemo.demo.services;

import com.beerdemo.demo.entities.User;
import com.beerdemo.demo.models.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User getUserById(long user_id);

    List<User> getAllUsers();

    User create(User user);

    User updateFirstName(long user_id, String firstName);

    User updateLastName(long user_id, String lastName);

    User updateEmail(long user_id, String eMail);

    User updatePassword(long user_id, String password);

    User updateUserName(long user_id, String userName);

    void delete(long id);

    List<User> getByName(String first_name);

    User loadUserByUsername(String username);

    void save(UserDto user);
}

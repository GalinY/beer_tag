package com.beerdemo.demo.repositories;

import com.beerdemo.demo.entities.User;

import java.util.List;

public interface UserRepository {

    // void updateUser(long user_id, String firstName, String lastName, String eMail, String password, int rights_id,
    // String userName);
    List<User> getByName(String first_name);


   User updateFirstName(long user_id, String firstName);

   User updateLastName(long user_id, String lastName);

   User updateEmail(long user_id, String eMail);

   User updatePassword(long user_id, String password);


   User updateUserName(long user_id, String userName);

   void delete(long id);

    User create(User user);

    User getById(long user_id);

    List<User> getAllUsers();

    User loadUserByUsername(String username);

    User findByEmail(String email);
}

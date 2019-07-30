package com.beerdemo.demo.services;

import com.beerdemo.demo.entities.Role;
import com.beerdemo.demo.entities.User;
import com.beerdemo.demo.models.UserDto;
import com.beerdemo.demo.repositories.RoleRepository;
import com.beerdemo.demo.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository repository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository repository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.repository = repository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository; 
    }

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User getUserById(long user_id)
    {
        return repository.getById(user_id);
    }
    @Override
    public List<User> getAllUsers() {
        return repository.getAllUsers();
    }

    @Override
    public User create(User user) {
        return repository.create(user);
    }

    @Override
    public User updateFirstName(long user_id, String firstName) {
        return repository.updateFirstName(user_id, firstName);
    }

    @Override
    public User updateLastName(long user_id, String lastName) {
        return repository.updateLastName(user_id, lastName);
    }

    @Override
    public User updateEmail(long user_id, String eMail) {
        return repository.updateEmail(user_id, eMail);
    }

    @Override
    public User updatePassword(long user_id, String password) {
        return repository.updatePassword(user_id, password);
    }

   // @Override
   // public void updateRights(long user_id, long rights_id) {
   //     repository.updateRole(user_id, rights_id);
   // }

    @Override
    public User updateUserName(long user_id, String userName) {
        return repository.updateUserName(user_id, userName);
    }

  /*  @Override
    public void updateUser(long user_id, String firstName, String lastName, String eMail, String password, int
    rights_id, String userName){
        repository.updateUser(user_id, firstName, lastName, eMail, password, rights_id, userName);
    }*/

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public List<User> getByName(String first_name) {
        return repository.getByName(first_name);
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.loadUserByUsername(username);
    }
    
    @Override

    public void save(UserDto user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        User userModel = new User();
        Role role = roleRepository.loadUserRightsByUserRightsName("ADMIN");
        BeanUtils.copyProperties(user, userModel);
        userModel.addRole(role);

        repository.create(userModel);
    }
}

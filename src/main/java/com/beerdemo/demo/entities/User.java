package com.beerdemo.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_address")
    private String eMail;

    @Column(name = "password")
    private String password;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "users_roles", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roles = new ArrayList<Role>();

    @Column(name = "username")
    private String username;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "user_beer_rating", joinColumns = {@JoinColumn(name = "beer_id")}, inverseJoinColumns =
            {@JoinColumn(name = "user_id")})
    private List<Beer> allBeers;

    public User() {
    }

    public User(long user_id, String username, String firstName, String lastName, String eMail, String password
    ) {
        this.user_id = user_id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.password = password;
    }

    public User(String username, String firstName, String lastName, String password, String eMail) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.eMail = eMail;

    }

    public void addRole(Role role) {
        roles.add(role);
        role.getUsers().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        return user_id == (((User) o).getUser_id());
    }

    @Override
    public int hashCode() {
        return ((Object) user_id).hashCode();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }


    public String geteMail() {
        return eMail;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public long getUser_id() {
        return user_id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setAuthorities(List<Role> roles) {
        this.roles = roles;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setUser_id(long id) {
        this.user_id = id;
    }
}

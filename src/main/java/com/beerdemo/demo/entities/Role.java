package com.beerdemo.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long role_id;

    @Column(name = "role_name")
    private String role_name;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private List<User> users = new ArrayList<User>();

    public Role() {
    }

    public Role(String role_name) {
        this.role_name = role_name;
    }

    @Override
    public String getAuthority() {
        return role_name;
    }

    public long getRole_id() {
        return role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setRole_id(long id) {
        this.role_id = id;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        return role_id == (((Role) o).getRole_id());
    }
 
    @Override
    public int hashCode() {
        return ((Object)role_id).hashCode();
    }
}

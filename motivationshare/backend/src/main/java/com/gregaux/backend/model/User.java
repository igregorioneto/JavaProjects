package com.gregaux.backend.model;

import com.gregaux.backend.enums.UserRole;
import jakarta.persistence.*;

import java.util.Set;

@MappedSuperclass
public class User <T> extends BaseEntity{
    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @ElementCollection(targetClass = UserRole.class)
    @Enumerated(EnumType.STRING)
    private Set<T> roles;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<T> getRoles() {
        return roles;
    }

    public void setRoles(Set<T> roles) {
        this.roles = roles;
    }
}

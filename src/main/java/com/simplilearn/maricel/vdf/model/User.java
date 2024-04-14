package com.simplilearn.maricel.vdf.model;

import jakarta.persistence.*;
import lombok.Cleanup;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    public User(String username, String password, String role, int enabled) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;
    @Column(name = "enabled")
    private int enabled;
}

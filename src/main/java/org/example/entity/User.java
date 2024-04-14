package org.example.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String password;

    private String roles;

    public String[] getRoleArray() {
        return this.roles.split(",");
    }

    public void setRoleArray(String[] roles) {
        this.roles = String.join(",", roles);
    }

}

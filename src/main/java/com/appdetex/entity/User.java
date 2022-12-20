package com.appdetex.entity;

import com.appdetex.request.CreateUserRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "roles_id")
    private Integer rolesId;

    public User(CreateUserRequest createUserRequest){
        this.id = createUserRequest.getId();
        this.name = createUserRequest.getName();
        this.email = createUserRequest.getEmail();
        this.password = createUserRequest.getPassword();
        this.rolesId = createUserRequest.getRolesId();
    }
}
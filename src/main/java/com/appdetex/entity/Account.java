package com.appdetex.entity;

import com.appdetex.request.CreateAccountRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    public Account(CreateAccountRequest createAccountRequest) {
        this.id = createAccountRequest.getId();
        this.name = createAccountRequest.getName();
    }
}

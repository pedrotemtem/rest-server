package com.appdetex.entity;

import com.appdetex.request.CreateAnalystRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "analysts")
public class Analyst {

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

    public Analyst(CreateAnalystRequest createAnalystRequest){
        this.id = createAnalystRequest.getId();
        this.name = createAnalystRequest.getName();
        this.email = createAnalystRequest.getEmail();
        this.password = createAnalystRequest.getPassword();
    }
}
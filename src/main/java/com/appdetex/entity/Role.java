package com.appdetex.entity;

import com.appdetex.request.CreateRoleRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "role")
    private String role;

    public Role(CreateRoleRequest createRoleRequest) {
        this.id = createRoleRequest.getId();
        this.role = createRoleRequest.getRole();
    }
}

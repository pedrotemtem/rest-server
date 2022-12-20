package com.appdetex.service;

import com.appdetex.entity.Role;
import com.appdetex.repository.RoleRepository;
import com.appdetex.request.CreateRoleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role createRole (CreateRoleRequest createRoleRequest){

        Role role = new Role(createRoleRequest);
        role = roleRepository.save(role);
        return role;
    }

    public String getRoleName(int roleID) {

        Role role = roleRepository.findById(roleID);

        return role.getRole();
    }

    public String deleteRole (int id){

        roleRepository.deleteById(id);
        return "Role has been deleted successfully";
    }


}

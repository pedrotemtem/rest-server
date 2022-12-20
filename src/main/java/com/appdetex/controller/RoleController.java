package com.appdetex.controller;

import com.appdetex.entity.Role;
import com.appdetex.request.CreateRoleRequest;
import com.appdetex.response.RoleResponse;
import com.appdetex.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/role/")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("getAll")
    public List<RoleResponse> getAllRoles() {

        List<Role> roleList = roleService.getAllRoles();
        List<RoleResponse> roleResponseList = new ArrayList<RoleResponse>();

        roleList.stream().forEach(role -> {
            roleResponseList.add(new RoleResponse(role));
        });

        return roleResponseList;
    }

    @GetMapping("getRoleName/{roleID}")
    public String getRoleName(@PathVariable int roleID){

        return roleService.getRoleName(roleID);
    }

    @PostMapping("create")
    public RoleResponse createRole(@RequestBody CreateRoleRequest createRoleRequest){

        Role role = roleService.createRole(createRoleRequest);
        return new RoleResponse(role);
    }

    @DeleteMapping("delete/{id}")
    public String deleteRole(@PathVariable int id){

        return roleService.deleteRole(id);
    }
}

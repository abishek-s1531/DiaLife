package com.diabetic.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.diabetic.demo.entity.Roles;
import com.diabetic.demo.service.RoleService;


@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/add")
    public Roles saveRole(@RequestBody Roles roles) {
        return roleService.saveRole(roles);
    }

    @GetMapping("/all")
    public List<Roles> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public Roles getRoleById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    @PutMapping("/{id}")
    public Roles updateRole(
            @RequestBody Roles roles,
            @PathVariable Long id) {
        return roleService.updateRole(roles, id);
    }

    @DeleteMapping("/{id}")
    public String deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        return "Role deleted successfully";
    }
}
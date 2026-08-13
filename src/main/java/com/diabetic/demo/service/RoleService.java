package com.diabetic.demo.service;

import java.util.List;

import com.diabetic.demo.entity.Roles;

public interface RoleService {

    Roles saveRole(Roles roles);

    List<Roles> getAllRoles();

    Roles getRoleById(Long id);

    Roles updateRole(Roles roles, Long id);

    void deleteRole(Long id);
}
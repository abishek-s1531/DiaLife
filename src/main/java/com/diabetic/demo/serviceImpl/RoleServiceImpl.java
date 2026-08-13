package com.diabetic.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diabetic.demo.entity.Roles;
import com.diabetic.demo.repository.RolesRepository;
import com.diabetic.demo.service.RoleService;



@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RolesRepository rolesRepository;

    public Roles saveRole(Roles roles) {
        return rolesRepository.save(roles);
    }

    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

    public Roles getRoleById(Long id) {
        return rolesRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found with id : " + id));
    }

    public Roles updateRole(Roles roles, Long id) {

        Roles existingRole = rolesRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found with id : " + id));
        existingRole.setName(roles.getName());

        return rolesRepository.save(existingRole);
    }

    public void deleteRole(Long id) {

        Roles existingRole = rolesRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found with id : " + id));
        rolesRepository.delete(existingRole);
    }
}
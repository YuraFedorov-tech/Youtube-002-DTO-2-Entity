package ru.yura.web.service;
/*
 *
 *@Data 16.04.2020
 *@autor Fedorov Yuri
 *@project Bootstrap3.1.3
 *
 */


import org.springframework.stereotype.Service;
import ru.yura.web.model.Role;
import ru.yura.web.repositiry.RoleRepository;

@Service
public class RoleService {
    final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    public void save(Role role) {
        roleRepository.save(role);
    }

    public Role findByRole(String role) {
        return roleRepository.findByRole(role);
    }

}


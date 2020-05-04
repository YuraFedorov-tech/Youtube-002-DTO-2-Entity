package ru.yura.web.repositiry;
/*
 *
 *@Data 13.04.2020
 *@autor Fedorov Yuri
 *@project Bootstrap3.1.3
 *
 */


import org.springframework.data.jpa.repository.JpaRepository;
import ru.yura.web.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>
{
  Role findByRole(String role);
}
package ru.yura.web.dto;
/*
 *
 *@Data 04.05.2020
 *@autor Fedorov Yuri
 *@project Bootstrap3.1.3
 *
 */

import java.util.List;

public class PersonDto {
    private Long id;
    private String email;
    private  String password;
    private List<String> roles;

    public PersonDto(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}

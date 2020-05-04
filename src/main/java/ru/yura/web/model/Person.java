package ru.yura.web.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

/*
 *
 *@Data 12.04.2020
 *@autor Fedorov Yuri
 *@project Bootstrap3.1.3
 *
 */
@Accessors(chain = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "Person")

public class Person implements UserDetails {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "MOTHER",
            joinColumns = @JoinColumn(name = "CHILD_ID"),
            inverseJoinColumns = @JoinColumn(name = "ID"))
    private Person mother;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "FATHER",
            joinColumns = @JoinColumn(name = "CHILD_ID"),
            inverseJoinColumns = @JoinColumn(name = "ID"))
    private Person father;

    @OneToOne (fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//    @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Person spouse;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Image> imageList=new HashSet<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "children", joinColumns = @JoinColumn(name = "CHILD_ID"))
    @Column(name = "childe")
    private Set<Long> idChildren;

    public void addChildren(Long idPerson) {
        idChildren.add(idPerson);
    }

    public void removeChildren(Long idPerson) {
        idChildren.remove(idPerson);
    }

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private List<Role> roles = new ArrayList<>();

    @Column(name = "email", unique = true)
    private String email;
    private String firstName;
    private String lastName;
    private String thirdName;
    private String birthday;
    private String dathDay;
    private String password;
    private String placeBorn;
    private String placeDeth;
    private String placeLiving;


//    @Lob
//    @Type(type = "org.hibernate.type.TextType")
    private String history;


    @Type(type="yes_no")
    private  boolean isAlive=true;

 //   TrueFalseType

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(email, person.email);
    }


    @Override
    public int hashCode() {
        return Objects.hash(email);
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    /*
     public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    public void setAuthorities(List<Role> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
     */
}

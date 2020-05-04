package ru.yura.web.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.*;

/*
 *
 *@Data 12.04.2020
 *@autor Fedorov Yuri
 *@project Bootstrap3.1.3
 *
 */
//
@Accessors(chain = true)
@Data
@NoArgsConstructor
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private boolean isMainFoto;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> commentsList=new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Image image = (Image) o;
        return Objects.equals(name, image.name);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}

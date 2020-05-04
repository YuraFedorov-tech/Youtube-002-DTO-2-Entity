package ru.yura.web.repositiry;
/*
 *
 *@Data 13.04.2020
 *@autor Fedorov Yuri
 *@project Bootstrap3.1.3
 *
 */


import org.springframework.data.jpa.repository.JpaRepository;
import ru.yura.web.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
    Image findByName(String name);
}
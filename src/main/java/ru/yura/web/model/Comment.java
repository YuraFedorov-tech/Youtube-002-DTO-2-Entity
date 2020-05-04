package ru.yura.web.model;
/*
 *
 *@Data 24.04.2020
 *@autor Fedorov Yuri
 *@project Bootstrap3.1.3
 *
 */

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Accessors(chain = true)
@Data
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String message;

    private String autorMessage;

    private LocalDate date= new Date().toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDate();

}

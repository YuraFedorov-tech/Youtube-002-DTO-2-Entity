package ru.yura.web.dao;
/*
 *
 *@Data 04.05.2020
 *@autor Fedorov Yuri
 *@project Bootstrap3.1.3
 *
 */

import ru.yura.web.dto.PersonDto;

import java.util.List;

public interface Dao <T>{
    List<PersonDto> getAllDto();
}

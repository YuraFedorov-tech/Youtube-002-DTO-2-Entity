package ru.yura.web.service;
/*
 *
 *@Data 13.04.2020
 *@autor Fedorov Yuri
 *@project Bootstrap3.1.3
 *
 */

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yura.web.dao.PersonDtoDao;
import ru.yura.web.dto.PersonDto;
import ru.yura.web.model.Image;
import ru.yura.web.model.Person;
import ru.yura.web.model.Role;
import ru.yura.web.repositiry.PersonRepositiry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class PersonService {
    final private PersonDtoDao personDtoDao;
    final private ImageService imageService;
    final private PersonRepositiry personRepositiry;
    final private RoleService roleService;

    public PersonService(ImageService imageService, PersonRepositiry personRepositiry, RoleService roleService, PersonDtoDao personDtoDao) {
        this.imageService = imageService;
        this.personRepositiry = personRepositiry;
        this.roleService = roleService;
        this.personDtoDao = personDtoDao;
    }

    @Transactional
    public void save(Person person, List<String> roles, List<String> images) {
        if (images.size() == 2) {
            int t = 0;
        }
        List<Role> roles1 = new ArrayList<>();
        for (String role : roles)
            roles1.add(roleService.findByRole(role));

        Set<Image> images1 = new HashSet<>();
        for (String img : images)
            images1.add(imageService.findByName(img));
        personRepositiry.save(person);
        person.setRoles(roles1);
        person.setImageList(images1);
    }

    @Transactional(readOnly = true)
    public List<Person> findAll() {
        return personRepositiry.findAll();
    }


    @Transactional(readOnly = true)
    public Person findById(Long id) {
        return personRepositiry.findPersonById(id);
    }

    public List<PersonDto> getAllDto() {
        return  personDtoDao.getAllDto();
    }
}

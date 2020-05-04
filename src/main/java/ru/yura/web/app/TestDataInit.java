package ru.yura.web.app;
/*
 *
 *@Data 03.05.2020
 *@autor Fedorov Yuri
 *@project Bootstrap3.1.3
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import ru.yura.web.dto.PersonDto;
import ru.yura.web.model.Image;
import ru.yura.web.model.Person;
import ru.yura.web.model.Role;
import ru.yura.web.service.ImageService;
import ru.yura.web.service.PersonService;
import ru.yura.web.service.RoleService;

import java.util.ArrayList;
import java.util.List;

public class TestDataInit {
    @Autowired
    ImageService imageService;
    @Autowired
    RoleService roleService;
    @Autowired
    PersonService personService;

    private void init() throws Exception {
        Role roleAdmin = new Role().setRole("ADMIN");
        Role rolePerson = new Role().setRole("PERSON");
        Role roleModerator = new Role().setRole("MODERATOR");
        roleService.save(roleAdmin);
        roleService.save(rolePerson);
        roleService.save(roleModerator);

        Image image1 = new Image().setName("firstImage");
        Image image2 = new Image().setName("secondImage");
        Image image3 = new Image().setName("thirdImage");
        imageService.save(image1);
        imageService.save(image2);
        imageService.save(image3);

        Person person1 = new Person().setEmail("2@2").setPassword("123");
        Person person2 = new Person().setEmail("3@3").setPassword("456");

        List<String> images = new ArrayList<>();
        images.add("firstImage");
        images.add("secondImage");
        List<String> roles = new ArrayList<>();
        roles.add("ADMIN");
        roles.add("PERSON");
        personService.save(person2, roles, images);

        roles.add("MODERATOR");
        images.add("thirdImage");
        personService.save(person1, roles, images);

        List<Person> personList = personService.findAll();

        List<PersonDto> personDtoList=personService.getAllDto();


    }
}

package ru.yura.web.dao;
/*
 *
 *@Data 04.05.2020
 *@autor Fedorov Yuri
 *@project Bootstrap3.1.3
 *
 */

import org.hibernate.query.Query;
import org.hibernate.transform.ResultTransformer;
import org.springframework.stereotype.Repository;
import ru.yura.web.dto.PersonDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;


@Repository
public class PersonDtoDaoImpl implements PersonDtoDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<PersonDto> getAllDto() {
        List<PersonDto> personDtoList = entityManager.createQuery(
                "SELECT p.id, p.email,p.password , r.role , img.name FROM Person p left join p.roles r left join p.imageList img"
        ).unwrap(Query.class)
                .setResultTransformer(new PersonDtoTransformer())
                .list();
        return personDtoList;
    }

    private static class PersonDtoTransformer implements ResultTransformer {
        List<PersonDto> root=new ArrayList<>();
        Map<Long , List<String>> rolesMap=new HashMap<>();
        Map<Long, List<String>> imgMap=new HashMap<>();
        @Override
        public Object transformTuple(Object[] tuple, String[] strings) {
            Long id= (Long) tuple[0];
            String email= (String) tuple[1];
            String password= (String) tuple[2];
            String role= (String) tuple[3];
            String imgName= (String) tuple[4];

            PersonDto personDto=new PersonDto(id, email,password);
            if(!rolesMap.containsKey(id)){
                root.add(personDto);
                rolesMap.put(id, new ArrayList<>());
                imgMap.put(id, new ArrayList<>());
            }
            if(role!=null){
                rolesMap.get(id).add(role);
            }
            if(imgName!=null){
                imgMap.get(id).add(imgName);
            }
            System.out.println(Arrays.toString(tuple));
            return root;
        }

        @Override
        public List transformList(List list) {
            for(PersonDto personDto:root){
               personDto.setRoles(rolesMap.get(personDto.getId()));
               personDto.setImages(imgMap.get(personDto.getId()));
            }
            return root;
        }
    }
}

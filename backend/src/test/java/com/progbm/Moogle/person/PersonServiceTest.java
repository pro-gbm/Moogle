package com.progbm.Moogle.person;

import com.progbm.Moogle.actor.Actor;
import com.progbm.Moogle.actor.ActorService;
import com.progbm.Moogle.director.Director;
import com.progbm.Moogle.director.DirectorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;
    @Autowired
    private ActorService actorService;
    @Autowired
    private DirectorService directorService;

    @Test
    @Transactional
    public void savePersonTest() {
        int page = 1;
        personService.savePerson(page);

        List<Actor> actors = actorService.findAll();
        List<Director> directors = directorService.findAll();


    }

}
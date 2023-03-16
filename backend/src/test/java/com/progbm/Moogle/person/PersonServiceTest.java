package com.progbm.Moogle.person;

import com.progbm.Moogle.actor.Actor;
import com.progbm.Moogle.actor.ActorService;
import com.progbm.Moogle.director.Director;
import com.progbm.Moogle.director.DirectorService;
import com.progbm.Moogle.util.Provider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;
    @Autowired
    private ActorService actorService;
    @Autowired
    private DirectorService directorService;

    @Test
//    @Transactional
    public void savePersonTest() {
        int page = 1;
        personService.savePerson(page);

        List<Actor> actors = actorService.findAll();
        List<Director> directors = directorService.findAll();


    }

    @Test
    public void mapTest() {
        final Map<Provider, Integer> map = new LinkedHashMap<>();
        map.put(Provider.AMAZON, 3);
        map.put(Provider.APPLE, 10);
        map.put(Provider.DISNEY, 1);
        map.put(Provider.NETFLIX, 5);

        Provider provider = map.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(Provider.NETFLIX);

        System.out.println("provider = " + provider);
    }
}
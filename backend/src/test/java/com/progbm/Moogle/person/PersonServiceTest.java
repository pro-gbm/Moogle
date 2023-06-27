package com.progbm.Moogle.person;

import com.progbm.Moogle.actor.Actor;
import com.progbm.Moogle.actor.ActorService;
import com.progbm.Moogle.director.Director;
import com.progbm.Moogle.director.DirectorService;
import com.progbm.Moogle.util.Provider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.EnumMap;
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
    @Transactional
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

    @Test
    public void countPeopleOttTest() {
        // given
        List<Long> actorIds = personService.getActors().stream().map(Actor::getId).toList();
        List<Long> directorIds = personService.getDirectors().stream().map(Director::getId).toList();

        // when
        Map<Provider, Integer> map = new EnumMap<>(Provider.class);
        personService.countPeopleOtt(map, actorIds, directorIds);

        // then
        String result = Provider.NETFLIX.toString();
        int count = map.get(Provider.NETFLIX);
        for (Map.Entry<Provider, Integer> entry : map.entrySet()) {
            String key = entry.getKey().toString();
            int value = entry.getValue();

            if (value > count) {
                result = key;
                count = value;
            }
        }

        for (Map.Entry<Provider, Integer> entry : map.entrySet()) {
            System.out.println("***********************");
            System.out.println("OTT = " + entry.getKey());
            System.out.println("count = " + entry.getValue());
            System.out.println("***********************");
        }
    }

}
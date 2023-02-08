package com.progbm.Moogle.actor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ActorServiceTest {

    @Autowired
    private ActorService actorService;

    @Test
    @Transactional
    public void saveActorTest() {
        actorService.saveActor();

        List<Actor> actors = actorService.findAll();

        System.out.println("actors.get(0) = " + actors.get(0).toString());
    }

    @Test
    public void birthdayToAgeTest() {
        String birthday = "1994-04-14";

        int age = actorService.birthDayToAge(birthday);

        assertThat(age).isEqualTo(28);
    }

}
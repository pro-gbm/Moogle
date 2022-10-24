package com.progbm.Moogle.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class UserRedisRepositoryTest {
    @Autowired
    private UserRedisRepository redisRepository;
    @Test
    public void basicSave() {
        // given
        User user = new User(null, "fisrt", "last");

        // when
        User savedUser = redisRepository.save(user);

        // then
        Optional<User> findUser = redisRepository.findById(savedUser.getId());

        assertThat(findUser.isPresent()).isEqualTo(Boolean.TRUE);
        assertThat(findUser.get().getFirstname()).isEqualTo(user.getFirstname());
    }
}
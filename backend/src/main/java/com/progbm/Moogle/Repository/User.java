package com.progbm.Moogle.Repository;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@Data
@RedisHash("user")
public class User {
    @Id
    String id;
    String firstname;
    String lastname;

    @Builder
    public User(String id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}

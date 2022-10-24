package com.progbm.Moogle.user;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@Data
@RedisHash("user")
public class User {
    @Id
    private String id;
    private String firstname;
    private String lastname;

    @Builder
    public User(String id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}

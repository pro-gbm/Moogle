package com.progbm.Moogle.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRedisRepository extends CrudRepository<User, String> {
}

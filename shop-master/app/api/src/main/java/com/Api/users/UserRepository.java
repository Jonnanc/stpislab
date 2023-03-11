package com.Api.users;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserPOJO, Integer> {
    List<UserPOJO> findByLogin(String login);
}
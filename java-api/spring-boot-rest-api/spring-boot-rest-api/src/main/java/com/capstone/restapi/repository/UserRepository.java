package com.capstone.restapi.repository;

import com.capstone.restapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Using JPA user repository interface and extending with custom methods
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value="SELECT * from users u where u.username=?1 AND upassword=?2", nativeQuery = true)
    List<User> loggedInUser(String username, String pass);

    @Query(value="SELECT * from users where id=?1", nativeQuery = true)
    User getUserById(String id);
}

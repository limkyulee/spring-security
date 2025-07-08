package com.kyuleeim.SpringSecurity.repo;

import com.kyuleeim.SpringSecurity.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author limkyulee
 * @version 1.0, 7/4/25
 * @see {참조}
 */

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

    Users findByUsername(String username);
}

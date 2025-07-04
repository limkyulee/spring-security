package com.kyuleeim.SpringSecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author limkyulee
 * @version 1.0, 7/4/25
 * @see {참조}
 */
public interface UserRepo extends JpaRepository<User, Integer> {
}

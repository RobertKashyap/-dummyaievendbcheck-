package com.local.dummyaievendbcheck.repos;

import com.local.dummyaievendbcheck.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}

package com.fast.compatiHomes.repo;

import com.fast.compatiHomes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

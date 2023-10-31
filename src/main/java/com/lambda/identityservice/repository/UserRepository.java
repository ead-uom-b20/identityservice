package com.lambda.identityservice.repository;

import com.lambda.identityservice.domain.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface UserRepository extends JpaRepository<UserDomain, Long> {
    List<UserDomain> findAllByUserrole (String role);
}

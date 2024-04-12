package com.cleanone.clean_one.infraestructure.drivenadapters;

import com.cleanone.clean_one.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
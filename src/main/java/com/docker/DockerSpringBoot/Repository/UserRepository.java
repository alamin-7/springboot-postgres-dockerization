package com.docker.DockerSpringBoot.Repository;

import com.docker.DockerSpringBoot.Models.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

package com.example.springbackend.repository;
import com.example.springbackend.entities.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User repository class uses jpa repository
 */
@Repository // Make class spring bean
/**
 * Interface that extends the jpa-repository provided by spring
 */
public interface UserRepository extends JpaRepository<ApplicationUser, Long>{
    ApplicationUser findByUsername(String username);
}

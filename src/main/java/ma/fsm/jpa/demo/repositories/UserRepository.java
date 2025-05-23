package ma.fsm.jpa.demo.repositories;

import ma.fsm.jpa.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}

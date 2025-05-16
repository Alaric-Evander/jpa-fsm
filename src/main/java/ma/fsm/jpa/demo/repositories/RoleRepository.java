package ma.fsm.jpa.demo.repositories;

import ma.fsm.jpa.demo.entities.Role;
import ma.fsm.jpa.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
}

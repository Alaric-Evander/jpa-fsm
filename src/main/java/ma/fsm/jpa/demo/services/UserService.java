package ma.fsm.jpa.demo.services;

import ma.fsm.jpa.demo.entities.Role;
import ma.fsm.jpa.demo.entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String username);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String username, String roleName);

}

package ma.fsm.jpa.demo.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.fsm.jpa.demo.entities.Role;
import ma.fsm.jpa.demo.entities.User;
import ma.fsm.jpa.demo.repositories.RoleRepository;
import ma.fsm.jpa.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {

        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = findUserByUserName(username);
        Role role = findRoleByRoleName(roleName);
        if (user.getRoles() != null) {
            user.getRoles().add(role);
            role.getUsers().add(user);
        }
        //userRepository.save(user);

    }

    @Override
    public User authentificate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if(user==null) {throw new RuntimeException("null");}
        if(user.getPassword().equals(password)) {
            return user;
        }
        throw new RuntimeException("Wrong password");
    }
}

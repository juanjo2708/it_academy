package academy.it.SpringBoot_jwt_1.service;

import academy.it.SpringBoot_jwt_1.entity.Role;
import academy.it.SpringBoot_jwt_1.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String userName, String roleName);
    User getUser(String userName);
    List<User> getUsers();
}

package academy.it.SpringBoot_jwt_1.repo;

import academy.it.SpringBoot_jwt_1.entity.Role;
import academy.it.SpringBoot_jwt_1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

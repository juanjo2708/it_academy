package academy.it.SpringBoot_jwt_1.repo;

import academy.it.SpringBoot_jwt_1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

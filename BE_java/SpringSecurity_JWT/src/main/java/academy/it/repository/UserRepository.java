package academy.it.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import academy.it.entity.User;

@Repository
public interface UserRepository extends JpaRepository <User, Integer>{

		
	User findByUserName(String username);

	

}

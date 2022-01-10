package academy.it.repository;

import java.util.List;

import org.apache.tomcat.jni.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Integer>{

	void saveAll(List<academy.it.entity.User> users);
	
	User findByUserName(String username);

	

}

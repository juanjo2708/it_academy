package academy.it.ApiRestMongo1.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import academy.it.ApiRestMongo1.entity.Usuari;


public interface UsuariRepository extends MongoRepository<Usuari, Integer>{
	
	List<Usuari> findByNom(String nom);
	
	@Query("{'Direccio.ciutat':?0}")
	List<Usuari> findByCiutat(String ciutat);

}

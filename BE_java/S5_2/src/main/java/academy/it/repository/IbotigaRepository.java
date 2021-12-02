package academy.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import academy.it.entity.Botiga;

@Repository
public interface IbotigaRepository extends JpaRepository<Botiga, Integer> {
	

}

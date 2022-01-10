package it.academy.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.academy.entity.Jugada;

@Repository
public interface IjugadaRepository extends CrudRepository <Jugada, Long> {

	Long deleteAllByJugador_id (Long jugador_id);
}

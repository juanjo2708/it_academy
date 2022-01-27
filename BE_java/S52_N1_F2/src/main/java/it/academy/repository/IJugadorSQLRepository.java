package it.academy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.academy.entity.Jugador;

@Repository
public interface IJugadorSQLRepository extends CrudRepository <Jugador, Long> {

}

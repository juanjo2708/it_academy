package it.academy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import it.academy.entity.Jugador;

@Repository
public interface IjugadorRepository extends MongoRepository <Jugador, Long> {

}

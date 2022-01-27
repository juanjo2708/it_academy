package cat.academy.it.S52_F2_2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import cat.academy.it.S52_F2_2.entity.Jugador;

@Repository
public interface IjugadorRepository extends MongoRepository <Jugador, Long> {

}

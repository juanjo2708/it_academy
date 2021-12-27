package it.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.academy.entity.Jugador;

@Repository
public interface IjugadorRepository extends JpaRepository <Jugador, Long> {

}

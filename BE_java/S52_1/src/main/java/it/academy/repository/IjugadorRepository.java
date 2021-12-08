package it.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.academy.entity.Jugador;

public interface IjugadorRepository extends JpaRepository <Jugador, Long> {

}

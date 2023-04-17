package br.edu.ifms.ConsoleTLP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.ConsoleTLP.modelo.Console;

public interface ConsoleRepository extends JpaRepository<Console, Long> {

}

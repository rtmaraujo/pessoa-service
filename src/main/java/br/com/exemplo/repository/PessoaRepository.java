package br.com.exemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.exemplo.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
	
}

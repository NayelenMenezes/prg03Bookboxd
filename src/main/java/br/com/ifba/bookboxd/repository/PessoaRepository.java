package br.com.ifba.bookboxd.repository;

import br.com.ifba.bookboxd.entity.Pessoa;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
    List<Pessoa> findByNomeContainingIgnoreCase (String nome);
    
    Optional<Pessoa> findByNomeIgnoreCase (String nome);
    
    boolean existsByNomeIgnoreCase (String nome);
}

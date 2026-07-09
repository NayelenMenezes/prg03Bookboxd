package br.com.ifba.bookboxd.editora.repository;

import br.com.ifba.bookboxd.editora.entity.Editora;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long>{
    Optional<Editora> findByNomeIgnoreCase(String nome);
    
    List<Editora> findByNomeContainingIgnoreCase(String nome);
    
    boolean existsByNomeIgnoreCase(String nome);
}

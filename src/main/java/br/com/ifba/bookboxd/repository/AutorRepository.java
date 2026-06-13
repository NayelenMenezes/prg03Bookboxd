package br.com.ifba.bookboxd.repository;

import br.com.ifba.bookboxd.entity.Autor;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long>{
    List<Autor> findByNacionalidade(String nacionalidade);
    
    Optional<Autor> findByPessoaId(Long pessoaId);
    
    boolean existsByPessoaId(Long pessoaId);
}

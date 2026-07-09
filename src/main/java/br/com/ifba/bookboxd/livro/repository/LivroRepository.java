package br.com.ifba.bookboxd.livro.repository;

import br.com.ifba.bookboxd.livro.entity.Livro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{
    //procura Livro por titulo ignorando o case sensitive
    List<Livro> findByTituloContainingIgnoreCase (String titulo);
    
    //procura Livro por gênero ignorando o case sensitive
    List<Livro> findByGeneroContainingIgnoreCase (String genero);
    
    //ver se aquele ISBN já existe
    boolean existsByIsbn (String isbn);
} 
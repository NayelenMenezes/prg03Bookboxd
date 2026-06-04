package br.com.ifba.bookboxd.repository;

import br.com.ifba.bookboxd.entity.Livro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{
    List<Livro> findByTituloContainingIgnoreCase (String titulo);
    
    List<Livro> findByGenero (String genero);
    
    boolean extitsByIsbn (String isbn);
} 
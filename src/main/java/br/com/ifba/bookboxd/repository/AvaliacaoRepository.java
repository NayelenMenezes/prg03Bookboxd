package br.com.ifba.bookboxd.repository;

import br.com.ifba.bookboxd.entity.Avaliacao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>{
    //todas avaliações de um livro especifico
    List<Avaliacao> findByLivroId(Long livroId);
    
    //todas as avaliações feitas por um usuario
    List<Avaliacao> findByUsuarioId(Long usuarioId);
    
    List<Avaliacao> findByLivroIdAndContemSpoiler(Long livroId, boolean contemSpoiler);
}

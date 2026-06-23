package br.com.ifba.bookboxd.repository;

import br.com.ifba.bookboxd.entity.Comentario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long>{
    //todos os comentarios de uma avaliação
    List<Comentario> findByAvaliacaoId(Long avaliacaoId);
    
    //todos comentarios feito por um usuario
    List<Comentario> findByUsuarioId(Long usuarioId);
}

package br.com.ifba.bookboxd.comentario.controller;

import br.com.ifba.bookboxd.comentario.entity.Comentario;
import java.util.List;
import java.util.Optional;

public interface ComentarioIController {
    // salva e atualiza comentario
    Comentario save(Comentario comentario);
    
    // busca um comentario pelo ID
    Optional<Comentario> findById(Long id);
    
    // deleta um comentario pelo ID
    void delete(Long id);
    
    // retorna todas comentario cadastrados
    List<Comentario> findAll();
    
   List<Comentario> findByAvaliacaoId(Long avaliacaoId);
   
   List<Comentario> findByUsuarioId(Long usuarioId);
   
   boolean editarTexto(Long comentarioId, String novoTexto);
}

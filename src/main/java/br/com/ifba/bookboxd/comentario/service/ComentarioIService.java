package br.com.ifba.bookboxd.comentario.service;

import br.com.ifba.bookboxd.comentario.entity.Comentario;
import java.util.List;
import java.util.Optional;

public interface ComentarioIService {
    // salva comentario
    Comentario save(Comentario comentario);
    
    // Atualiza comentario
    Comentario update(Comentario comentario);
    
    // busca um comentario pelo ID
    Optional<Comentario> findById(Long id);
    
    // deleta um comentario pelo ID
    void delete(Long id);
    
    // retorna todas comentario
    List<Comentario> findAll();
    
   List<Comentario> findByAvaliacaoId(Long avaliacaoId);
   
   List<Comentario> findByUsuarioId(Long usuarioId);
   
   void editarTexto(Long comentarioId, String novoTexto);
}

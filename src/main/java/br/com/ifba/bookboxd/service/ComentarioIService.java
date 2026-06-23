package br.com.ifba.bookboxd.service;

import br.com.ifba.bookboxd.entity.Comentario;
import java.util.List;
import java.util.Optional;

public interface ComentarioIService {
    // salva e atualiza comentario
    Comentario save(Comentario comentario);
    
    // busca um comentario pelo ID
    Optional<Comentario> findById(Long id);
    
    // deleta um comentario pelo ID
    void delete(Long id);
    
    // retorna todas comentario
    List<Comentario> findAll();
    
   List<Comentario> findByAvaliacaoId(Long avaliacaoId);
   
   List<Comentario> findByUsuarioId(Long usuarioId);
   
   boolean editarTexto(Long comentarioId, String novoTexto);
}

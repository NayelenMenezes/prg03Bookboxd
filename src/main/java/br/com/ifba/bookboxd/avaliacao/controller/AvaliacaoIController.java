package br.com.ifba.bookboxd.avaliacao.controller;

import br.com.ifba.bookboxd.avaliacao.entity.Avaliacao;
import br.com.ifba.bookboxd.comentario.entity.Comentario;
import br.com.ifba.bookboxd.usuario.entity.Usuario;
import java.util.List;
import java.util.Optional;


public interface AvaliacaoIController {
    // salva e atualiza avaliacao
    Avaliacao save(Avaliacao avaliacao);
    
    // busca uma avaliacao pelo ID
    Optional<Avaliacao> findById(Long id);
    
    // deleta uma avaliacao pelo ID
    void delete(Long id);
    
    // retorna todas as avaliacao
    List<Avaliacao> findAll();
    
    // busca avaliacao por livro
    List<Avaliacao> findByLivroId(Long livroId);
    
    //busca avaliação pelo usuaario
    List<Avaliacao> findByUsuarioId(Long usuarioId);
    
    void editarTexto(Long avaliacaoId, String novoTexto);
    
    Comentario adicionarComentario(Long avaliacaoId, Usuario autor, String texto);
    
    void toggleSpoiler(Long avaliacaoId);
}

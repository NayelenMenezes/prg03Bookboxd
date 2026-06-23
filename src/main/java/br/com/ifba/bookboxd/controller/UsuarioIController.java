package br.com.ifba.bookboxd.controller;

import br.com.ifba.bookboxd.entity.Avaliacao;
import br.com.ifba.bookboxd.entity.ListaLeitura;
import br.com.ifba.bookboxd.entity.Livro;
import br.com.ifba.bookboxd.entity.Usuario;
import java.util.List;
import java.util.Optional;


public interface UsuarioIController {
    // salva e atualiza usuario
    Usuario save(Usuario usuario);
    
    // busca autor pelo ID
    Optional<Usuario> findById(Long id);
    
    // deleta autor pelo ID
    void delete(Long id);
    
    // retorna todos os autores cadastrados
    List<Usuario> findAll();
    
    Optional<Usuario> autenticar(String email, String senha);
    
    boolean alterarSenha(Long usuarioId, String senhaAntiga, String novaSenha);
    
    void editarPerfil(Long usuarioId, String nome, String bio);
    
    ListaLeitura criarListaLeitura(Long usuarioId, String nome, String descricao);
    
    Avaliacao avaliarLivro(Long usuarioId, Livro livro, int nota, String comentario, boolean contemSpoiler);
}

package br.com.ifba.bookboxd.service;

import br.com.ifba.bookboxd.entity.Avaliacao;
import br.com.ifba.bookboxd.entity.ListaLeitura;
import br.com.ifba.bookboxd.entity.Livro;
import br.com.ifba.bookboxd.entity.Usuario;
import java.util.List;
import java.util.Optional;


public interface UsuarioIService {
    // salva e atualiza usuario
    Usuario save(Usuario usuario);
    
    // busca usuario pelo ID
    Optional<Usuario> findById(Long id);
    
    // deleta usuario pelo ID
    void delete(Long id);
    
    // retorna todos os usuario cadastrados
    List<Usuario> findAll();
    
    Optional<Usuario> autenticar(String email, String senha);
    
    boolean alterarSenha(Long usuarioId, String senhaAntiga, String novaSenha);
    
    void editarPerfil(Long usuarioId, String nome, String bio);
    
    ListaLeitura criarListaLeitura(Long usuarioId, String nome, String descricao);
    
    Avaliacao avaliarLivro(Long usuarioId, Livro livro, int nota,String comentario, boolean contemSpoiler);
    
}

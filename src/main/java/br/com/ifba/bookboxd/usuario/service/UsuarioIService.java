package br.com.ifba.bookboxd.usuario.service;


import br.com.ifba.bookboxd.listaleitra.entity.ListaLeitura;
import br.com.ifba.bookboxd.usuario.entity.Usuario;
import java.util.List;
import java.util.Optional;


public interface UsuarioIService {
    // salva usuario
    Usuario save(Usuario usuario);
    
    //atualiza usuario
    Usuario update(Usuario usuario);
    
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
    
    
}

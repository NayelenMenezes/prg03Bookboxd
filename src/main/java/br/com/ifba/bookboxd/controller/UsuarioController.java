package br.com.ifba.bookboxd.controller;

import br.com.ifba.bookboxd.entity.Avaliacao;
import br.com.ifba.bookboxd.entity.ListaLeitura;
import br.com.ifba.bookboxd.entity.Livro;
import br.com.ifba.bookboxd.entity.Usuario;
import br.com.ifba.bookboxd.service.UsuarioIService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UsuarioController implements UsuarioIController{
    private final UsuarioIService usuarioService;

    @Override
    public Usuario save(Usuario usuario) {
        log.info("Controller: salvando usuário: {}", usuario.getEmail());
        return usuarioService.save(usuario);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        log.info("Controller: buscando usuário por ID: {}", id);
        return usuarioService.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.info("Controller: deletando usuario com ID: {}", id);
        usuarioService.delete(id);
    }

    @Override
    public List<Usuario> findAll() {
        log.info("Controller: listando todas os usuários");
        return usuarioService.findAll();
    }

    @Override
    public Optional<Usuario> autenticar(String email, String senha) {
        log.info("Controller: tentativa de autenticação para: {}", email);
        return usuarioService.autenticar(email, senha);
    }

    @Override
    public boolean alterarSenha(Long usuarioId, String senhaAntiga, String novaSenha) {
        log.info("Controller: alterando senha do usuário ID: {}", usuarioId);
        return usuarioService.alterarSenha(usuarioId, senhaAntiga, novaSenha);
    }

    @Override
    public void editarPerfil(Long usuarioId, String nome, String bio) {
        log.info("Controller: editando perfil do usuário ID: {}", usuarioId);
        usuarioService.editarPerfil(usuarioId, nome, bio);
    }

    @Override
    public ListaLeitura criarListaLeitura(Long usuarioId, String nome, String descricao) {
        log.info("Controller: criando lista '{}' para usuário ID: {}", nome, usuarioId);
        return usuarioService.criarListaLeitura(usuarioId, nome, descricao);
    }

    @Override
    public Avaliacao avaliarLivro(Long usuarioId, Livro livro, int nota, String comentario, boolean contemSpoiler) {
        log.info("Controller: usuário ID {} avaliando livro '{}'", usuarioId, livro.getTitulo());
        return usuarioService.avaliarLivro(usuarioId, livro, nota, comentario, contemSpoiler);
    }
    
}

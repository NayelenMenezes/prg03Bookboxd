package br.com.ifba.bookboxd.service;

import br.com.ifba.bookboxd.entity.Avaliacao;
import br.com.ifba.bookboxd.entity.ListaLeitura;
import br.com.ifba.bookboxd.entity.Livro;
import br.com.ifba.bookboxd.entity.Usuario;
import br.com.ifba.bookboxd.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsuarioService implements UsuarioIService {
    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario save(Usuario usuario) {
        log.info("Salvando usuario: {}", usuario.getPessoa().getNome());
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        log.info("Buscando usuario por ID: {}", id);
        return usuarioRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.info("Deletando usuario com ID: {}", id);
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<Usuario> findAll() {
        log.info("Listando todos os usuarios");
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> autenticar(String email, String senha) {
        log.info("Autenticando usuário: {}", email);
        return usuarioRepository.findByEmail(email).filter(u -> u.autenticar(email, senha));
    }

    @Override
    public boolean alterarSenha(Long usuarioId, String senhaAntiga, String novaSenha) {
        log.info("Alterando senha do usuário ID: {}", usuarioId);
        return usuarioRepository.findById(usuarioId).map(usuario -> {
            boolean sucesso = usuario.alterarSenha(novaSenha, novaSenha);
            if (sucesso) usuarioRepository.save(usuario);
            return sucesso;
        }).orElse(false);
    }

    @Override
    public void editarPerfil(Long usuarioId, String nome, String bio) {
        log.info("Editando perfil do usuário ID: {}", usuarioId);
        usuarioRepository.findById(usuarioId).ifPresent(usuario -> {
            usuario.editarPerfil(nome, bio);
            usuarioRepository.save(usuario);
        });
    }

    @Override
    public ListaLeitura criarListaLeitura(Long usuarioId, String nome, String descricao) {
        log.info("Criando lista '{}' para usuário ID: {}", nome, usuarioId);
        return usuarioRepository.findById(usuarioId).map(usuario -> {
            ListaLeitura lista = usuario.criarListaLeitura(nome, descricao);
            usuarioRepository.save(usuario);
            return lista;
        }).orElseThrow(() -> new RuntimeException("Usuário não encontrado: " + usuarioId));
    }

    @Override
    public Avaliacao avaliarLivro(Long usuarioId, Livro livro, int nota, String comentario, boolean contemSpoiler) {
        log.info("Usuário ID {} avaliando livro '{}'", usuarioId, livro.getTitulo());
        return usuarioRepository.findById(usuarioId).map(usuario -> {
            Avaliacao avaliacao = usuario.avaliarLivro(livro, nota, comentario, contemSpoiler);
            usuarioRepository.save(usuario);
            return avaliacao;
        }).orElseThrow(() -> new RuntimeException("Usuário não encontrado: " + usuarioId));
    }
  
}

package br.com.ifba.bookboxd.usuario.controller;

import br.com.ifba.bookboxd.listaleitra.entity.ListaLeitura;
import br.com.ifba.bookboxd.usuario.entity.Usuario;
import br.com.ifba.bookboxd.usuario.service.UsuarioIService;
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
        try{
            log.info("Controller: salvando usuário: {}", usuario.getEmail());
            return usuarioService.save(usuario);
        } catch (RuntimeException e){
            log.error("Controller: erro ao salvar usuario - {}", e.getMessage());
            throw e;
        }
    }
    
    @Override
    public Usuario update(Usuario usuario) {
        try {
            log.info("Controller: atualizando usuario");
            return usuarioService.update(usuario);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao atualizar usuario - {}", e.getMessage());
            throw e;
        }
    }
    
    @Override
    public Optional<Usuario> findById(Long id) {
        try {
            log.info("Controller: buscando usuario por ID: {}", id);
            return usuarioService.findById(id);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao buscar usuario id {} - {}", id, e.getMessage());
            throw e;
        }
    }

    @Override
    public void delete(Long id) {
        try {
            log.info("Controller: deletando usuario com ID: {}", id);
            usuarioService.delete(id);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao deletar usuario id {} - {}", id, e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Usuario> findAll() {
        try {
            log.info("Controller: listando todos os usuarios");
            return usuarioService.findAll();
        } catch (RuntimeException e) {
            log.error("Controller: erro ao listar usuarios - {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public Optional<Usuario> autenticar(String email, String senha) {
        try {
            log.info("Controller: autenticando usuário: {}", email);
            return usuarioService.autenticar(email, senha);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao autenticar usuário {} - {}", email, e.getMessage());
            throw e;
        }
    }

    @Override
    public boolean alterarSenha(Long usuarioId, String senhaAntiga, String novaSenha) {
        try {
            log.info("Controller: alterando senha do usuário ID: {}", usuarioId);
            return usuarioService.alterarSenha(usuarioId, senhaAntiga, novaSenha);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao alterar senha do usuário id {} - {}", usuarioId, e.getMessage());
            throw e;
        }
    }

    @Override
    public void editarPerfil(Long usuarioId, String nome, String bio) {
        try {
            log.info("Controller: editando perfil do usuário ID: {}", usuarioId);
            usuarioService.editarPerfil(usuarioId, nome, bio);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao editar perfil do usuário id {} - {}", usuarioId, e.getMessage());
            throw e;
        }
    }

    @Override
    public ListaLeitura criarListaLeitura(Long usuarioId, String nome, String descricao) {
        try {
            log.info("Controller: criando lista de leitura para usuário ID: {}", usuarioId);
            return usuarioService.criarListaLeitura(usuarioId, nome, descricao);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao criar lista de leitura para usuário id {} - {}", usuarioId, e.getMessage());
            throw e;
        }
    }
}

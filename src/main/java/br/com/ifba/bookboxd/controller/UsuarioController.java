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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Usuario> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<Usuario> autenticar(String email, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean alterarSenha(Long usuarioId, String senhaAntiga, String novaSenha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editarPerfil(Long usuarioId, String nome, String bio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ListaLeitura criarListaLeitura(Long usuarioId, String nome, String descricao) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Avaliacao avaliarLivro(Long usuarioId, Livro livro, int nota, String comentario, boolean contemSpoiler) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

package br.com.ifba.bookboxd.service;

import br.com.ifba.bookboxd.entity.ListaLeitura;
import br.com.ifba.bookboxd.entity.Usuario;
import br.com.ifba.bookboxd.infrastruture.util.StringUtil;
import br.com.ifba.bookboxd.repository.UsuarioRepository;
import java.time.LocalDate;
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
    
    private void validarUsuario(Usuario usuario){
        if(usuario == null){
            throw new RuntimeException("Dados do Usuario não preenchidos");
        }
        if(usuario.getPessoa() == null){
            throw new RuntimeException("O Usuario precisa estar vinculado a uma Pessoa");
        }
        if(StringUtil.isEmailValido(usuario.getEmail())){
            throw new RuntimeException("Email inválido");
        }
        if(StringUtil.isEmpty(usuario.getSenha())){
            throw new RuntimeException("A senha do Usuario é obrigatória");
        }
    }
    
    private void validarId(Long id){
        if(StringUtil.isIdValido(id)){
            throw new RuntimeException("id inválido");
        }
    }

    @Override
    public Usuario save(Usuario usuario) {
        validarUsuario(usuario);
        if(usuario.getId() != null){
            throw new RuntimeException("Usuário ja existe no banco de dados");
        }
        if(usuarioRepository.findByEmail(usuario.getEmail()).isPresent()){
            throw new RuntimeException("Já existe um usuario cadastrado com este email");
        }
        if(usuario.getDataCadastro() == null){
            usuario.setDataCadastro(LocalDate.now());
        }
        
        log.info("Salvando usuario: {}", usuario.getPessoa().getNome());
        return usuarioRepository.save(usuario);
    }
    
    @Override
    public Usuario update(Usuario usuario) {
        validarUsuario(usuario);
        validarId(usuario.getId());
        
        if(!usuarioRepository.existsById(usuario.getId())){
            throw new RuntimeException("Usuario não encontrado com id: " + usuario.getId());
        }
        log.info("Atualizando usuario: {}", usuario.getPessoa().getNome());
        return usuarioRepository.save(usuario);
    }
    
    @Override
    public Optional<Usuario> findById(Long id) {
        validarId(id);
        log.info("Buscando usuario por ID: {}", id);
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        
        if(usuario.isEmpty()){
            throw new RuntimeException("Usuario não encontrado com id: " + id);
        }
        return usuario;
    }

    @Override
    public void delete(Long id) {
        validarId(id);
        
        if(!usuarioRepository.existsById(id)){
            throw new RuntimeException("Usuario não encontrado com id: " + id);
        }
        log.info("Deletando usuario com ID: {}", id);
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<Usuario> findAll() {
        log.info("Listando todos os usuarios");
        List<Usuario> usuarios = usuarioRepository.findAll();
        
        if(usuarios.isEmpty()){
            throw new RuntimeException("Nenhum usuario cadastrado");
        }
        return usuarios;
    }

    @Override
    public Optional<Usuario> autenticar(String email, String senha) {
        if(StringUtil.isEmpty(email) || StringUtil.isEmpty(senha)){
            throw new RuntimeException("Email e senha são obrigatórios para autenticação");
        }
        
        log.info("Autenticando usuário: {}", email);
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email)
                .filter(u -> u.autenticar(email, senha));
        
        if(usuario.isEmpty()){
            throw new RuntimeException("Email ou senha inválidos");
        }
        
        return usuario;
    }

    @Override
    public boolean alterarSenha(Long usuarioId, String senhaAntiga, String novaSenha) {
        validarId(usuarioId);
        
        if(StringUtil.isEmpty(senhaAntiga) || StringUtil.isEmpty(novaSenha)){
            throw new RuntimeException("Senha antiga e nova senha são obrigatórias");
        }
        
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado com id: " + usuarioId));
        
        log.info("Alterando senha do usuário ID: {}", usuarioId);
        boolean sucesso = usuario.alterarSenha(senhaAntiga, novaSenha);
        
        if(!sucesso){
            throw new RuntimeException("Senha antiga incorreta");
        }
        
        usuarioRepository.save(usuario);
        return true;
    }

    @Override
    public void editarPerfil(Long usuarioId, String nome, String bio) {
        validarId(usuarioId);
        
        if(StringUtil.isEmpty(nome)){
            throw new RuntimeException("O nome não pode ser vazio");
        }
        
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado com id: " + usuarioId));

        log.info("Editando perfil do usuário ID: {}", usuarioId);
        usuario.editarPerfil(nome, bio);
        usuarioRepository.save(usuario);
    }

    @Override
    public ListaLeitura criarListaLeitura(Long usuarioId, String nome, String descricao) {
        validarId(usuarioId);
        
        if(StringUtil.isEmpty(nome)){
            throw new RuntimeException("O nome da Lista de Leitura é obrigatório");
        }
        
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado com id: " + usuarioId));

        log.info("Criando lista '{}' para usuário ID: {}", nome, usuarioId);
        ListaLeitura lista = usuario.criarListaLeitura(nome, descricao);
        usuarioRepository.save(usuario);
        return lista;
    }
}

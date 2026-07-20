package br.com.ifba.bookboxd.comentario.service;

import br.com.ifba.bookboxd.comentario.entity.Comentario;
import br.com.ifba.bookboxd.comentario.repository.ComentarioRepository;
import br.com.ifba.bookboxd.infrastruture.util.StringUtil;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ComentarioService implements ComentarioIService{
    private final ComentarioRepository comentarioRepository;
    
    private void validarComentario(Comentario comentario){
        if(comentario == null){
            throw new RuntimeException("Dados do comentário não preenchidos");
        }
        if(comentario.getUsuario() == null){
            throw new RuntimeException("O comentário precisa estar vinculado a um Usuario");
        }
        if(comentario.getAvaliacao() == null){
            throw new RuntimeException("O comentário precisa estar vinculado a uma Avaliação");
        }
        if(StringUtil.isEmpty(comentario.getTexto())){
            throw new RuntimeException("O texto do comentário não pode ser vazio");
        }
    }
    
    private void validarId(Long id) {
        if (!StringUtil.isIdValido(id)) {
            throw new RuntimeException("Id inválido");
        }
    }
    
    @Override
    public Comentario save(Comentario comentario) {
        validarComentario(comentario);
        
        if (comentario.getId() != null) {
            throw new RuntimeException("Comentário já existe no banco de dados");
        }
        if (comentario.getDataComentario() == null) {
            comentario.setDataComentario(LocalDate.now());
        }
        
        log.info("Salvando comentário na avaliação ID: {}", comentario.getAvaliacao().getId());
        return comentarioRepository.save(comentario);
    }
    
    @Override
    public Comentario update(Comentario comentario) {
        validarComentario(comentario);
        validarId(comentario.getId());
        if(!comentarioRepository.existsById(comentario.getId())){
            throw new RuntimeException("Comentário não encontrado com id: " + comentario.getId());
        }
        log.info("Atualizando comentário na avaliação ID: {}", comentario.getAvaliacao().getId());
        return comentarioRepository.save(comentario);
    }
    
    @Override
    public Optional<Comentario> findById(Long id) {
        validarId(id);
        
        log.info("Buscando comentário por ID: {}", id);
        Optional<Comentario> comentario = comentarioRepository.findById(id);

        if (comentario.isEmpty()) {
            throw new RuntimeException("Comentário não encontrado com id: " + id);
        }
        return comentario;
    }

    @Override
    public void delete(Long id) {
        validarId(id);
        
        if (!comentarioRepository.existsById(id)) {
            throw new RuntimeException("Comentário não encontrado com id: " + id);
        }

        log.info("Deletando comentário com ID: {}", id);
        comentarioRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<Comentario> findAll() {
        log.info("Listando todos os comentários");
        List<Comentario> comentarios = comentarioRepository.findAll();

        if (comentarios.isEmpty()) {
            throw new RuntimeException("Nenhum comentário cadastrado");
        }
        return comentarios;
    }

    @Override
    @Transactional
    public List<Comentario> findByAvaliacaoId(Long avaliacaoId) {
        validarId(avaliacaoId);
        
        log.info("Buscando comentários da avaliação ID: {}", avaliacaoId);
        List<Comentario> comentarios = comentarioRepository.findByAvaliacaoId(avaliacaoId);

        if (comentarios.isEmpty()) {
            throw new RuntimeException("Nenhum comentário encontrado para a avaliação id: " + avaliacaoId);
        }
        return comentarios;
    }

    @Override
    @Transactional
    public List<Comentario> findByUsuarioId(Long usuarioId) {
        validarId(usuarioId);

        log.info("Buscando comentários do usuário ID: {}", usuarioId);
        List<Comentario> comentarios = comentarioRepository.findByUsuarioId(usuarioId);

        if (comentarios.isEmpty()) {
            throw new RuntimeException("Nenhum comentário encontrado para o usuário id: " + usuarioId);
        }
        return comentarios;
    }
    
    //edita texto do comentário
    @Override
    public void editarTexto(Long comentarioId, String novoTexto) {
        validarId(comentarioId);
        
        if (StringUtil.isEmpty(novoTexto)) {
            throw new RuntimeException("O novo texto do comentário não pode ser vazio");
        }
        
        Comentario comentario = comentarioRepository.findById(comentarioId)
                .orElseThrow(() -> new RuntimeException("Comentário não encontrado com id: " + comentarioId));

        log.info("Editando texto do comentário ID: {}", comentarioId);
        comentario.editarTexto(novoTexto);
        comentarioRepository.save(comentario);
    } 
}

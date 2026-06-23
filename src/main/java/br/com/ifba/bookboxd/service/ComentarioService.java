package br.com.ifba.bookboxd.service;

import br.com.ifba.bookboxd.entity.Comentario;
import br.com.ifba.bookboxd.repository.ComentarioRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ComentarioService implements ComentarioIService{
    private final ComentarioRepository comentarioRepository;
    
    @Override
    public Comentario save(Comentario comentario) {
        log.info("Salvando comentário na avaliação ID: {}", comentario.getAvaliacao().getId());
        return comentarioRepository.save(comentario);
    }

    @Override
    public Optional<Comentario> findById(Long id) {
        log.info("Buscando comentário por ID: {}", id);
        return comentarioRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.info("Deletando comentário com ID: {}", id);
        comentarioRepository.deleteById(id);
    }

    @Override
    public List<Comentario> findAll() {
        log.info("Listando todos os comentários");
        return comentarioRepository.findAll();
    }

    @Override
    public List<Comentario> findByAvaliacaoId(Long avaliacaoId) {
        log.info("Buscando comentários da avaliação ID: {}", avaliacaoId);
        return comentarioRepository.findByAvaliacaoId(avaliacaoId);
    }

    @Override
    public List<Comentario> findByUsuarioId(Long usuarioId) {
        log.info("Buscando comentários do usuário ID: {}", usuarioId);
        return comentarioRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public boolean editarTexto(Long comentarioId, String novoTexto) {
        log.info("Editando texto do comentário ID: {}", comentarioId);
        return comentarioRepository.findById(comentarioId).map(comentario ->{
            comentario.editarTexto(novoTexto);
            if(!comentario.validarConteudo()){
                log.warn("Texto inválido para o comentário ID: {}", comentarioId);
                return false;
            }
            comentarioRepository.save(comentario);
            return true;
        }).orElse(false);
    }
    
}

package br.com.ifba.bookboxd.controller;

import br.com.ifba.bookboxd.entity.Comentario;
import br.com.ifba.bookboxd.service.ComentarioIService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ComentarioController implements ComentarioIController{
    private final ComentarioIService comentarioService;
    
    @Override
    public Comentario save(Comentario comentario) {
        log.info("Controller: salvando comentário");
        return comentarioService.save(comentario);
    }

    @Override
    public Optional<Comentario> findById(Long id) {
        log.info("Controller: buscando comentário por ID: {}", id);
        return comentarioService.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.info("Controller: deletando comentário ID: {}", id);
        comentarioService.delete(id);
    }

    @Override
    public List<Comentario> findAll() {
        log.info("Controller: listando todos os comentários");
        return comentarioService.findAll();
    }

    @Override
    public List<Comentario> findByAvaliacaoId(Long avaliacaoId) {
        log.info("Controller: buscando comentários da avaliação ID: {}", avaliacaoId);
        return comentarioService.findByAvaliacaoId(avaliacaoId);
    }

    @Override
    public List<Comentario> findByUsuarioId(Long usuarioId) {
        log.info("Controller: buscando comentários do usuário ID: {}", usuarioId);
        return comentarioService.findByUsuarioId(usuarioId);
    }

    @Override
    public boolean editarTexto(Long comentarioId, String novoTexto) {
        log.info("Controller: editando texto do comentário ID: {}", comentarioId);
        return comentarioService.editarTexto(comentarioId, novoTexto);
    }
    
}

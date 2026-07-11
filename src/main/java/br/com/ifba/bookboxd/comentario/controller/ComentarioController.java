package br.com.ifba.bookboxd.comentario.controller;

import br.com.ifba.bookboxd.comentario.entity.Comentario;
import br.com.ifba.bookboxd.comentario.service.ComentarioIService;
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
        try {
            log.info("Controller: salvando comentário");
            return comentarioService.save(comentario);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao salvar comentário - {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public Comentario update(Comentario comentario) {
        try {
            log.info("Controller: atualizando comentário");
            return comentarioService.update(comentario);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao atualizar comentário - {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public Optional<Comentario> findById(Long id) {
        try {
            log.info("Controller: buscando comentário por ID: {}", id);
            return comentarioService.findById(id);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao buscar comentário id {} - {}", id, e.getMessage());
            throw e;
        }
    }

    @Override
    public void delete(Long id) {
        try {
            log.info("Controller: deletando comentário com ID: {}", id);
            comentarioService.delete(id);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao deletar comentário id {} - {}", id, e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Comentario> findAll() {
        try {
            log.info("Controller: listando todos os comentários");
            return comentarioService.findAll();
        } catch (RuntimeException e) {
            log.error("Controller: erro ao listar comentários - {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Comentario> findByAvaliacaoId(Long avaliacaoId) {
        try {
            log.info("Controller: buscando comentários da avaliação ID: {}", avaliacaoId);
            return comentarioService.findByAvaliacaoId(avaliacaoId);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao buscar comentários da avaliação id {} - {}", avaliacaoId, e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Comentario> findByUsuarioId(Long usuarioId) {
        try {
            log.info("Controller: buscando comentários do usuário ID: {}", usuarioId);
            return comentarioService.findByUsuarioId(usuarioId);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao buscar comentários do usuário id {} - {}", usuarioId, e.getMessage());
            throw e;
        }
    }

    @Override
    public void editarTexto(Long comentarioId, String novoTexto) {
        try {
            log.info("Controller: editando texto do comentário ID: {}", comentarioId);
            comentarioService.editarTexto(comentarioId, novoTexto);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao editar texto do comentário id {} - {}", comentarioId, e.getMessage());
            throw e;
        }
    }
}

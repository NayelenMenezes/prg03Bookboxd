package br.com.ifba.bookboxd.avaliacao.controller;

import br.com.ifba.bookboxd.avaliacao.entity.Avaliacao;
import br.com.ifba.bookboxd.comentario.entity.Comentario;
import br.com.ifba.bookboxd.avaliacao.service.AvaliacaoIService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

//controller de avaliação
@Slf4j
@Controller
@RequiredArgsConstructor
public class AvaliacaoController implements AvaliacaoIController{
    
    private final AvaliacaoIService avaliacaoService;
    
    @Override
    public Avaliacao save(Avaliacao avaliacao) {
        try {
            log.info("Controller: salvando avaliação");
            return avaliacaoService.save(avaliacao);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao salvar avaliação - {}", e.getMessage());
            throw e;
        }
    }
    
    @Override
    public Avaliacao update(Avaliacao avaliacao) {
        try {
            log.info("Controller: atualizando avaliação");
            return avaliacaoService.update(avaliacao);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao atualizar avaliação - {}", e.getMessage());
            throw e;
        }
    }
    
    @Override
    public Optional<Avaliacao> findById(Long id) {
        try {
            log.info("Controller: buscando avaliação por ID: {}", id);
            return avaliacaoService.findById(id);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao buscar avaliação id {} - {}", id, e.getMessage());
            throw e;
        }
    }

    @Override
    public void delete(Long id) {
        try {
            log.info("Controller: deletando avaliação com ID: {}", id);
            avaliacaoService.delete(id);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao deletar avaliação id {} - {}", id, e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Avaliacao> findAll() {
        try {
            log.info("Controller: listando todas as avaliações");
            return avaliacaoService.findAll();
        } catch (RuntimeException e) {
            log.error("Controller: erro ao listar avaliações - {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Avaliacao> findByLivroId(Long livroId) {
        try {
            log.info("Controller: buscando avaliações do livro ID: {}", livroId);
            return avaliacaoService.findByLivroId(livroId);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao buscar avaliações do livro id {} - {}", livroId, e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Avaliacao> findByUsuarioId(Long usuarioId) {
        try {
            log.info("Controller: buscando avaliações do usuário ID: {}", usuarioId);
            return avaliacaoService.findByUsuarioId(usuarioId);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao buscar avaliações do usuário id {} - {}", usuarioId, e.getMessage());
            throw e;
        }
    }

    @Override
    public void editarTexto(Long avaliacaoId, String novoTexto) {
        try {
            log.info("Controller: editando texto da avaliação ID: {}", avaliacaoId);
            avaliacaoService.editarTexto(avaliacaoId, novoTexto);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao editar texto da avaliação id {} - {}", avaliacaoId, e.getMessage());
            throw e;
        }
    }

    @Override
    public Comentario adicionarComentario(Long avaliacaoId, Long autorId, String texto) {
        try {
            log.info("Controller: adicionando comentário na avaliação ID: {}", avaliacaoId);
            return avaliacaoService.adicionarComentario(avaliacaoId, autorId, texto);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao adicionar comentário na avaliação id {} - {}", avaliacaoId, e.getMessage());
            throw e;
        }
    }

    @Override
    public void toggleSpoiler(Long avaliacaoId) {
        try {
            log.info("Controller: alternando spoiler da avaliação ID: {}", avaliacaoId);
            avaliacaoService.toggleSpoiler(avaliacaoId);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao alternar spoiler da avaliação id {} - {}", avaliacaoId, e.getMessage());
            throw e;
        }
    }
    
     @Override
    public Avaliacao criarAvaliacao(Long usuarioId, Long livroId, int nota, String texto, boolean contemSpoiler) {
        try {
            log.info("Controller: criando avaliação do usuário {} para o livro {}", usuarioId, livroId);
            return avaliacaoService.criarAvaliacao(usuarioId, livroId, nota, texto, contemSpoiler);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao criar avaliação - {}", e.getMessage());
            throw e;
        }
    }
}

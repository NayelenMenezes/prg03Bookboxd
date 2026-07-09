package br.com.ifba.bookboxd.avaliacao.controller;

import br.com.ifba.bookboxd.avaliacao.entity.Avaliacao;
import br.com.ifba.bookboxd.comentario.entity.Comentario;
import br.com.ifba.bookboxd.usuario.entity.Usuario;
import br.com.ifba.bookboxd.avaliacao.service.AvaliacaoIService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AvaliacaoController implements AvaliacaoIController{
    
    private final AvaliacaoIService avaliacaoService;
    
    @Override
    public Avaliacao save(Avaliacao avaliacao) {
        log.info("Controller: salvando avaliação");
        return avaliacaoService.save(avaliacao);
    }

    @Override
    public Optional<Avaliacao> findById(Long id) {
        log.info("Controller: buscando avaliação por ID: {}", id);
        return avaliacaoService.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.info("Controller: deletando avaliação ID: {}", id);
        avaliacaoService.delete(id);
    }

    @Override
    public List<Avaliacao> findAll() {
        log.info("Controller: listando todas as avaliações");
        return avaliacaoService.findAll();
    }

    @Override
    public List<Avaliacao> findByLivroId(Long livroId) {
         log.info("Controller: buscando avaliações do livro ID: {}", livroId);
        return avaliacaoService.findByLivroId(livroId);
    }

    @Override
    public List<Avaliacao> findByUsuarioId(Long usuarioId) {
        log.info("Controller: buscando avaliações do usuário ID: {}", usuarioId);
        return avaliacaoService.findByUsuarioId(usuarioId);
    }

    @Override
    public void editarTexto(Long avaliacaoId, String novoTexto) {
        log.info("Controller: editando texto da avaliação ID: {}", avaliacaoId);
        avaliacaoService.editarTexto(avaliacaoId, novoTexto);
    }

    @Override
    public Comentario adicionarComentario(Long avaliacaoId, Usuario autor, String texto) {
        log.info("Controller: adicionando comentário na avaliação ID: {}", avaliacaoId);
        return avaliacaoService.adicionarComentario(avaliacaoId, autor, texto);
    }

    @Override
    public void toggleSpoiler(Long avaliacaoId) {
        log.info("Controller: alternando spoiler da avaliação ID: {}", avaliacaoId);
        avaliacaoService.toggleSpoiler(avaliacaoId);
    }
    
}

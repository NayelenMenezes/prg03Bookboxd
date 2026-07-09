package br.com.ifba.bookboxd.avaliacao.service;

import br.com.ifba.bookboxd.avaliacao.service.AvaliacaoIService;
import br.com.ifba.bookboxd.avaliacao.entity.Avaliacao;
import br.com.ifba.bookboxd.comentario.entity.Comentario;
import br.com.ifba.bookboxd.livro.entity.Livro;
import br.com.ifba.bookboxd.usuario.entity.Usuario;
import br.com.ifba.bookboxd.avaliacao.repository.AvaliacaoRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AvaliacaoService implements AvaliacaoIService {
    
    private final AvaliacaoRepository avaliacaoRepository; 
    
    @Override
    public Avaliacao save(Avaliacao avaliacao) {
        log.info("Salvando avaliação do livro ID: {}", avaliacao.getLivro().getId());
        return avaliacaoRepository.save(avaliacao);
    }

    @Override
    public Optional<Avaliacao> findById(Long id) {
        log.info("Buscando avaliação por ID: {}", id);
        return avaliacaoRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.info("Deletando avaliação com ID: {}", id);
        avaliacaoRepository.deleteById(id);
    }

    @Override
    public List<Avaliacao> findAll() {
        log.info("Listando todas as avaliações");
        return avaliacaoRepository.findAll();
    }

    @Override
    public List<Avaliacao> findByLivroId(Long livroId) {
        log.info("Buscando avaliações do livro ID: {}", livroId);
        return avaliacaoRepository.findByLivroId(livroId);
    }

    @Override
    public List<Avaliacao> findByUsuarioId(Long usuarioId) {
        log.info("Buscando avaliações do usuário ID: {}", usuarioId);
        return avaliacaoRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public void editarTexto(Long avaliacaoId, String novoTexto) {
        log.info("Editando texto da avaliação ID: {}", avaliacaoId);
        avaliacaoRepository.findById(avaliacaoId).ifPresent(avaliacao -> {
            avaliacao.editarTexto(novoTexto);
            avaliacaoRepository.save(avaliacao);
        });
    }

    @Override
    public Comentario adicionarComentario(Long avaliacaoId, Usuario autor, String texto) {
        log.info("Adicionando comentario na avaliação ID: {}", avaliacaoId);
        return avaliacaoRepository.findById(avaliacaoId).map(avaliacao -> {
            Comentario comentario = avaliacao.adicionarComentario(autor, texto);
            avaliacaoRepository.save(avaliacao);
            return comentario;
        }).orElseThrow(() -> new RuntimeException("Avaliação não encontrada: " + avaliacaoId));
    }

    @Override
    public void toggleSpoiler(Long avaliacaoId) {
        log.info("Alternando spoiler da avaliação ID: {}", avaliacaoId);
        avaliacaoRepository.findById(avaliacaoId).ifPresent(avaliacao -> {
            avaliacao.toggleSpoiler();
            avaliacaoRepository.save(avaliacao);
        });
    } 
    
    @Override
    public Avaliacao criarAvaliacao(Usuario usuario, Livro livro, int nota, String comentario, boolean contemSpoiler) {
        
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setUsuario(usuario);
        avaliacao.setLivro(livro);
        avaliacao.setNota(nota);
        avaliacao.setComentario(comentario);
        avaliacao.setContemSpoiler(contemSpoiler);
        avaliacao.setDataPublicacao(LocalDate.EPOCH.now());

        return avaliacaoRepository.save(avaliacao);
    }
}

package br.com.ifba.bookboxd.avaliacao.service;

import br.com.ifba.bookboxd.avaliacao.entity.Avaliacao;
import br.com.ifba.bookboxd.comentario.entity.Comentario;
import br.com.ifba.bookboxd.livro.entity.Livro;
import br.com.ifba.bookboxd.usuario.entity.Usuario;
import br.com.ifba.bookboxd.avaliacao.repository.AvaliacaoRepository;
import br.com.ifba.bookboxd.infrastruture.util.StringUtil;
import br.com.ifba.bookboxd.livro.repository.LivroRepository;
import br.com.ifba.bookboxd.usuario.repository.UsuarioRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//service de avaliação
@Slf4j
@Service
@RequiredArgsConstructor
public class AvaliacaoService implements AvaliacaoIService {
    
    private final AvaliacaoRepository avaliacaoRepository;
    private final UsuarioRepository usuarioRepository;
    private final LivroRepository livroRepository; 
    
    private void validarAvaliacao(Avaliacao avaliacao) {
        if(avaliacao == null) {
            throw new RuntimeException("Dados de avaliação não preenchidos");
        }
        if(avaliacao.getUsuario() == null) {
            throw new RuntimeException("A avaliação precisa estar vinculada a um Usuario");
        }
        if(avaliacao.getLivro() == null) {
            throw new RuntimeException("A avaliação precisa estar vinculada a um Livro");
        }
        if(avaliacao.getNota() < 0 || avaliacao.getNota() > 5) {
            throw new RuntimeException("Nota precisa estar entre 0 e 5");
        }
        if(StringUtil.isEmpty(avaliacao.getAvaliacao())) {
            throw new RuntimeException("Avaliação não preenchida");
        }
    }
    
    private void validarId(Long id){
        if(!StringUtil.isIdValido(id)){
            throw new RuntimeException("Id inválido");
        }
    }
    
    @Override
    public Avaliacao save(Avaliacao avaliacao) {
        validarAvaliacao(avaliacao);
        if(avaliacao.getId() != null){
            throw new RuntimeException("Avaliação ja existe no banco de dados");
        }
        if(avaliacao.getDataPublicacao() == null){
            avaliacao.setDataPublicacao(LocalDate.now());
        }
        
        log.info("Salvando avaliação do livro ID: {}", avaliacao.getLivro().getId());
        return avaliacaoRepository.save(avaliacao);
    }
    
    @Override
    public Avaliacao update(Avaliacao avaliacao) {
        validarAvaliacao(avaliacao);
        validarId(avaliacao.getId());
        
        if(!avaliacaoRepository.existsById(avaliacao.getId())){
            throw new RuntimeException("Avaliação não encontrado com id: " + avaliacao.getId());
        }
        
        log.info("Atualizando avaliação do livro ID: {}", avaliacao.getLivro().getId());
        return avaliacaoRepository.save(avaliacao);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Avaliacao> findById(Long id) {
        validarId(id);
        log.info("Buscando avaliação por ID: {}", id);
        Optional<Avaliacao> avaliacao = avaliacaoRepository.findById(id);
        
        if(avaliacao.isEmpty()){
            throw new RuntimeException("Avaliacao não encontrado com id: " + id);
        }
        Hibernate.initialize(avaliacao.get().getComentarios());
        return avaliacao;
    }

    @Override
    public void delete(Long id) {
        validarId(id);
        
        if(!avaliacaoRepository.existsById(id)){
            throw new RuntimeException("Avaliacao não encontradoa com id: " + id);
        }
        log.info("Deletando avaliação com ID: {}", id);
        avaliacaoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<Avaliacao> findAll() {
        log.info("Listando todas as avaliações");
        
        List<Avaliacao> avaliacoes = avaliacaoRepository.findAll();
        
        if(avaliacoes.isEmpty()){
            throw new RuntimeException("Nenhuma avaliacao encontrada");
        }
        return avaliacoes;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Avaliacao> findByLivroId(Long livroId) {
        validarId(livroId);
        log.info("Buscando avaliações do livro ID: {}", livroId);
        List<Avaliacao> avaliacoes = avaliacaoRepository.findByLivroId(livroId);
        
        if(avaliacoes.isEmpty()){
            throw new RuntimeException("Nenhuma avaliação encontrada para o livro id: " + livroId);
        }
        avaliacoes.forEach(a -> Hibernate.initialize(a.getComentarios()));
        return avaliacoes;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Avaliacao> findByUsuarioId(Long usuarioId) {
        validarId(usuarioId);
        log.info("Buscando avaliações do usuário ID: {}", usuarioId);
        List<Avaliacao> avaliacoes = avaliacaoRepository.findByUsuarioId(usuarioId);

        if (avaliacoes.isEmpty()) {
            throw new RuntimeException("Nenhuma avaliação encontrada para o usuário id: " + usuarioId);
        }

        avaliacoes.forEach(a -> Hibernate.initialize(a.getComentarios()));
        return avaliacoes;
    }
    
    //editar o texto da avaliação
    @Override
    public void editarTexto(Long avaliacaoId, String novoTexto) {
        validarId(avaliacaoId);
        if(StringUtil.isEmpty(novoTexto)){
            throw new RuntimeException("O novo texto da avaliação não pode ser vazio");
        }
        
        Avaliacao avaliacao = avaliacaoRepository.findById(avaliacaoId)
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada com id: " + avaliacaoId));
        
        log.info("Editando texto da avaliação ID: {}", avaliacaoId);
        avaliacao.editarTexto(novoTexto);
        avaliacaoRepository.save(avaliacao);
    }

    //adiciona novos comentarios a avaliacao
    @Override
    @Transactional
    public Comentario adicionarComentario(Long avaliacaoId, Long autorId, String texto) {
        validarId(avaliacaoId);
        validarId(autorId);
        
        if(StringUtil.isEmpty(texto)){
            throw new RuntimeException("O texto do comentário não pode ser vazio");
        }
        
        Avaliacao avaliacao = avaliacaoRepository.findById(avaliacaoId)
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada com id: " + avaliacaoId));
        
        Usuario autor = usuarioRepository.findById(autorId)
                .orElseThrow(() -> new RuntimeException("Usuário (autor do comentário) não encontrado com id: " + autorId));
        
        log.info("Adicionando comentario na avaliação ID: {}", avaliacaoId);
        Comentario comentario = avaliacao.adicionarComentario(autor, texto);
        avaliacaoRepository.save(avaliacao);
        return comentario;
    }

    //ver se avaliação contem spoiler
    @Override
    public void toggleSpoiler(Long avaliacaoId) {
        validarId(avaliacaoId);
        
        Avaliacao avaliacao = avaliacaoRepository.findById(avaliacaoId)
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada com id: " + avaliacaoId));
        
        log.info("Alternando spoiler da avaliação ID: {}", avaliacaoId);
        avaliacao.toggleSpoiler();
        avaliacaoRepository.save(avaliacao);
    } 
    
    //cria nova avaliação
    @Override
    @Transactional
    public Avaliacao criarAvaliacao(Long usuarioId, Long livroId, int nota, String texto, boolean contemSpoiler) {
        validarId(usuarioId);
        validarId(livroId);
        
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com id: " + usuarioId));

        Livro livro = livroRepository.findById(livroId)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com id: " + livroId));
        
        Avaliacao avaliacao = usuario.criarAvaliacao(livro, nota, texto, contemSpoiler);
        
        return save(avaliacao);
    }
}

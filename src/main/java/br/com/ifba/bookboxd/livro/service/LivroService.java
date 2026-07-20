package br.com.ifba.bookboxd.livro.service;

import br.com.ifba.bookboxd.avaliacao.entity.Avaliacao;
import br.com.ifba.bookboxd.livro.entity.Livro;
import br.com.ifba.bookboxd.infrastruture.util.StringUtil;
import br.com.ifba.bookboxd.livro.repository.LivroRepository;
import org.hibernate.Hibernate;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j 
@Service 
@RequiredArgsConstructor 
public class LivroService implements LivroIService {
    
    private final LivroRepository livroRepository;
    
    private void validarLivro(Livro livro) {
        if(livro == null) {
            throw new RuntimeException("Dados do Livro não preenchidos");
        }
        if(StringUtil.isEmpty(livro.getTitulo())) {
            throw new RuntimeException("O título do Livro é obrigatório");
        }
        if(!StringUtil.isAnoValido(livro.getAnoPublicacao())) {
            throw new RuntimeException("Ano de publicação inválido");
        }
        if(livro.getAutor() == null) {
            throw new RuntimeException("O Livro precisa ter um Autor vinculado");
        }
    }
    
    private void validarId(Long id) {
        if(!StringUtil.isIdValido(id)) {
            throw new RuntimeException("Id inválido");
        }
    }

        
    @Override
    public Livro save(Livro livro) {
        validarLivro(livro);
        
        if(livro.getId() != null){
            throw new RuntimeException("Livro já existe no banco de dados");
        }
        
        log.info("Salvando livro: {}", livro.getTitulo());
        return livroRepository.save(livro);
    }
    
    @Override
    public Livro update(Livro livro) {
        validarLivro(livro);
        validarId(livro.getId());
        
        if(!livroRepository.existsById(livro.getId())){
            throw new RuntimeException("Livro não encontrado com id: " + livro.getId());
        }
        
        log.info("Atualizando livro: {}", livro.getTitulo());
        return livroRepository.save(livro);
    }
        
    @Override
    @Transactional(readOnly = true)
    public Optional<Livro> findById(Long id) {
        validarId(id);

        log.info("Buscando livro por ID: {}", id);
        Optional<Livro> livro = livroRepository.findById(id);

        if (livro.isEmpty()) {
            throw new RuntimeException("Livro não encontrado com id: " + id);
        }
        Hibernate.initialize(livro.get().getAvaliacoes());

        return livro;
    }

    @Override
    public void delete(Long id) {
        validarId(id);
        
        if(!livroRepository.existsById(id)){
            throw new RuntimeException("Livro não encontrado com id: " +id);
        }
        
        log.info("Deletando livro com ID: {}", id);
        livroRepository.deleteById(id); 
    }

    @Override
    @Transactional(readOnly = true)
    public List<Livro> findAll() {
        log.info("Listando todos os livros");
        List<Livro> livros = livroRepository.findAll();

        if (livros.isEmpty()) {
            throw new RuntimeException("Nenhum livro cadastrado");
        }

        livros.forEach(l -> Hibernate.initialize(l.getAvaliacoes()));
        return livros; 
    }

    @Override
    @Transactional
    public List<Livro> findByTitulo(String titulo) {
        if(StringUtil.isEmpty(titulo)){
            throw new RuntimeException("Titulo pra busca não pode ser vazio");
        }
        log.info("Buscando livros pelo título: {}", titulo);
        List<Livro> livros = livroRepository.findByTituloContainingIgnoreCase(titulo);
        
        if(livros.isEmpty()){
            throw new RuntimeException("Nenhum livro encontrado com título: " + titulo);
        }
        return livros;
    }
    
    @Override
    @Transactional
    public List<Livro> findByGenero(String genero) {
        if(StringUtil.isEmpty(genero)){
            throw new RuntimeException("Gênero pra busca não pode ser vazio");
        }
        
        log.info("Buscando livros pelo gênero: {}", genero);
        List<Livro> livros = livroRepository.findByGeneroContainingIgnoreCase(genero);
        
        if(livros.isEmpty()){
            throw new RuntimeException("Nenhum livro encontrado com o gênero: " + genero);
        }
        return livros;
    }
    
    //calcula a media das avaliações
    @Override
    public double calcularMediaAvaliacoes(Long livroId) {
        validarId(livroId);
        
        log.info("Calculando media das avaliações do livro iD: {}", livroId);
        return livroRepository.findById(livroId).map(Livro::calcularMediaAvaliacao)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com id: " + livroId));
    }
    
    //adiciona a avaliação se encontrar livro e nota tiver entre 1 e 5
    @Override
    public void adicionarAvaliacao(Long livroId, Avaliacao avaliacao) {
        validarId(livroId);
        
        if(avaliacao == null){
            throw new RuntimeException("Dados da Avaliação não preenchidos");
        }
        if(avaliacao.getNota() < 0 || avaliacao.getNota() > 5){
            throw new RuntimeException("A nota da avaliação dever estar entre 0 e 5");
        }
        
        Livro livro = livroRepository.findById(livroId)
                .orElseThrow(() -> new RuntimeException("livro não encontrado com id: " + livroId));
        
        log.info("Adicionanco avaloação ao livro ID: {}", livroId);
        livro.adicionarAvaliacao(avaliacao);
        livroRepository.save(livro);
    } 
}

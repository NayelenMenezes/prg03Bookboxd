package br.com.ifba.bookboxd.service;

import br.com.ifba.bookboxd.entity.Livro;
import br.com.ifba.bookboxd.repository.LivroRepository;
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

    @Override
    public Livro save(Livro livro) {
        log.info("Salvando livro: {}", livro.getTitulo());
        return livroRepository.save(livro);
    }

    @Override
    public Optional<Livro> findById(Long id) {
        log.info("Buscando livro por ID: {}", id);
        return livroRepository.findById(id);
    }

    @Override
    public Livro update(Livro livro) {
        log.info("Atualizando livro com ID: {}", livro.getId());
        return livroRepository.save(livro);
    }

    @Override
    public void delete(Long id) {
        log.info("Deletando livro com ID: {}", id);
        livroRepository.deleteById(id);
    }

    @Override
    public List<Livro> findAll() {
        log.info("Listando todos os livros");
        return livroRepository.findAll();
    }

    @Override
    public List<Livro> findByTitulo(String titulo) {
        log.info("Buscando livros pelo título: {}", titulo);
        return livroRepository.findByTituloContainingIgnoreCase(titulo);
    }

    @Override
    public List<Livro> findByGenero(String genero) {
        log.info("Buscando livros peloo gênero: {}", genero);
        return livroRepository.findByGenero(genero);
    }

    
}

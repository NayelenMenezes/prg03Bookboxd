package br.com.ifba.bookboxd.service;

import br.com.ifba.bookboxd.entity.Livro;
import br.com.ifba.bookboxd.repository.LivroRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j //Injeta automaticamente o logger 'log' para registrar mensagens no console
@Service //Define esta classe como um componente de serviço
@RequiredArgsConstructor //Cria o construtor automaticamente para a injeção do repository
public class LivroService implements LivroIService {
    
    private final LivroRepository livroRepository; // Dependência do banco de dados

    @Override
    public Livro save(Livro livro) {
        log.info("Salvando livro: {}", livro.getTitulo());
        return livroRepository.save(livro); // Salva o novo registro no banco
    }

    @Override
    public Optional<Livro> findById(Long id) {
        log.info("Buscando livro por ID: {}", id);
        return livroRepository.findById(id); // Busca por ID retornando um Optional
    }

    @Override
    public void delete(Long id) {
        log.info("Deletando livro com ID: {}", id);
        livroRepository.deleteById(id); // Remove o registro do banco através do ID
    }

    @Override
    public List<Livro> findAll() {
        log.info("Listando todos os livros");
        return livroRepository.findAll(); // Retorna todos os livros cadastrados
    }

    @Override
    public List<Livro> findByTitulo(String titulo) {
        log.info("Buscando livros pelo título: {}", titulo);
        // Busca ignorando maiúsculas/minúsculas e aceitando trechos do nome
        return livroRepository.findByTituloContainingIgnoreCase(titulo);
    }

    @Override
    public List<Livro> findByGenero(String genero) {
        log.info("Buscando livros pelo gênero: {}", genero);
        // Busca ignorando maiúsculas/minúsculas e aceitando trechos do gênero
        return livroRepository.findByGeneroContainingIgnoreCase(genero);
    }
}

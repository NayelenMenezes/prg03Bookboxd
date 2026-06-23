package br.com.ifba.bookboxd.service;

import br.com.ifba.bookboxd.entity.Editora;
import br.com.ifba.bookboxd.entity.Livro;
import br.com.ifba.bookboxd.repository.EditoraRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EditoraService implements EditoraIService{

    private final EditoraRepository editoraRepository;
    
    @Override
    public Editora save(Editora editora) {
        log.info("Salvando editora: {}", editora.getNome());
        return editoraRepository.save(editora);
    }

    @Override
    public Optional<Editora> findById(Long id) {
        log.info("Buscando editora por ID: {}", id);
        return editoraRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.info("Deletando editora com ID: {}", id);
        editoraRepository.deleteById(id);
    }

    @Override
    public List<Editora> findAll() {
        log.info("Listando todas as editoras");
        return editoraRepository.findAll();
    }

    @Override
    public List<Editora> findByNome(String nome) {
        log.info("Buscando editoras pelo nome: {}", nome);
        return editoraRepository.findByNomeContainingIgnoreCase(nome);
    }

    @Override
    public void atualizarDadosContato(Long editoraId, String novoSite) {
        log.info("Atualizando site da editora ID: {}", editoraId);
        editoraRepository.findById(editoraId).ifPresent(editora ->{
           editora.atualizarDadosContato(novoSite);
           editoraRepository.save(editora);
        });
    }

    @Override
    public void adicionarLivro(Long editoraId, Livro livro) {
        log.info("Adicionando livro '{}' a editora ID: {}", livro.getTitulo(), editoraId);
        editoraRepository.findById(editoraId).ifPresent(editora -> {
           editora.adicionarLivro(livro);
           editoraRepository.save(editora);
        });
    }
    
}

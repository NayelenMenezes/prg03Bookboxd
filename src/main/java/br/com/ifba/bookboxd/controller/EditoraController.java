package br.com.ifba.bookboxd.controller;

import br.com.ifba.bookboxd.entity.Editora;
import br.com.ifba.bookboxd.entity.Livro;
import br.com.ifba.bookboxd.service.EditoraIService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class EditoraController implements EditoraIController{
    
    private final EditoraIService editoraService;
    
    @Override
    public Editora save(Editora editora) {
        log.info("Controller: salvando editora: {}", editora.getNome());
        return editoraService.save(editora);
    }

    @Override
    public Optional<Editora> findById(Long id) {
        log.info("Controller: buscando editora por ID: {}", id);
        return editoraService.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.info("Controller: deletando editora com ID: {}", id);
        editoraService.delete(id);
    }

    @Override
    public List<Editora> findAll() {
        log.info("Controller: listando todas as editoras");
        return editoraService.findAll();
    }

    @Override
    public List<Editora> findByNome(String nome) {
        log.info("Controller: buscando editoras pelo nome: {}", nome);
        return editoraService.findByNome(nome);
    }

    @Override
    public void atualizarDadosContato(Long editoraId, String novoSite) {
        log.info("Controller: atualizando contato da editora ID: {}", editoraId);
        editoraService.atualizarDadosContato(editoraId, novoSite);
    }

    @Override
    public void adicionarLivro(Long editoraId, Livro livro) {
        log.info("Controller: adicionando livro à editora ID: {}", editoraId);
        editoraService.adicionarLivro(editoraId, livro);
    }
    
}

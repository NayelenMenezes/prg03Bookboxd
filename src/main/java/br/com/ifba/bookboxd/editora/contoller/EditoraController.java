package br.com.ifba.bookboxd.editora.contoller;

import br.com.ifba.bookboxd.editora.entity.Editora;
import br.com.ifba.bookboxd.editora.service.EditoraIService;
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
        try {
            log.info("Controller: salvando editora");
            return editoraService.save(editora);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao salvar editora - {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public Editora update(Editora editora) {
        try {
            log.info("Controller: atualizando editora");
            return editoraService.update(editora);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao atualizar editora - {}", e.getMessage());
            throw e;
        }
    }
    
    @Override
    public Optional<Editora> findById(Long id) {
        try {
            log.info("Controller: buscando editora por ID: {}", id);
            return editoraService.findById(id);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao buscar editora id {} - {}", id, e.getMessage());
            throw e;
        }
    }

    @Override
    public void delete(Long id) {
        try {
            log.info("Controller: deletando editora com ID: {}", id);
            editoraService.delete(id);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao deletar editora id {} - {}", id, e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Editora> findAll() {
        try {
            log.info("Controller: listando todas as editoras");
            return editoraService.findAll();
        } catch (RuntimeException e) {
            log.error("Controller: erro ao listar editoras - {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Editora> findByNome(String nome) {
        try {
            log.info("Controller: buscando editoras pelo nome: {}", nome);
            return editoraService.findByNome(nome);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao buscar editoras pelo nome {} - {}", nome, e.getMessage());
            throw e;
        }
    }

    @Override
    public void atualizarDadosContato(Long editoraId, String novoSite) {
        try {
            log.info("Controller: atualizando dados de contato da editora ID: {}", editoraId);
            editoraService.atualizarDadosContato(editoraId, novoSite);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao atualizar contato da editora id {} - {}", editoraId, e.getMessage());
            throw e;
        }
    }

    @Override
    public void adicionarLivro(Long editoraId, Long livroId) {
        try {
            log.info("Controller: adicionando livro ID {} à editora ID: {}", livroId, editoraId);
            editoraService.adicionarLivro(editoraId, livroId);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao adicionar livro {} à editora id {} - {}", livroId, editoraId, e.getMessage());
            throw e;
        }
    }
}

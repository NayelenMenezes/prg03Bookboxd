package br.com.ifba.bookboxd.autor.controller;

import br.com.ifba.bookboxd.autor.entity.Autor;
import br.com.ifba.bookboxd.livro.entity.Livro;
import br.com.ifba.bookboxd.autor.service.AutorIService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AutorController implements AutorIController{
    private final AutorIService autorService;
    
    @Override
    public Autor save(Autor autor) {
        try {
            log.info("Controller: salvando autor");
            return autorService.save(autor);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao salvar autor - {}", e.getMessage());
            throw e;
        }
    }
    
    @Override
    public Autor update(Autor autor) {
        try {
            log.info("Controller: atualizando autor");
            return autorService.update(autor);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao atualizar autor - {}", e.getMessage());
            throw e;
        }
    }
    
    @Override
    public Optional<Autor> findById(Long id) {
        try {
            log.info("Controller: buscando autor por ID: {}", id);
            return autorService.findById(id);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao buscar autor id {} - {}", id, e.getMessage());
            throw e;
        }
    }

    @Override
    public void delete(Long id) {
        try {
            log.info("Controller: deletando autor com ID: {}", id);
            autorService.delete(id);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao deletar autor id {} - {}", id, e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Autor> findAll() {
        try {
            log.info("Controller: listando todos os autores");
            return autorService.findAll();
        } catch (RuntimeException e) {
            log.error("Controller: erro ao listar autores - {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Autor> findByNacionalide(String nacionalidade) {
        try {
            log.info("Controller: buscando autor pela nacionalidade: {}", nacionalidade);
            return autorService.findByNacionalide(nacionalidade);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao buscar autor pela nacionalidade {} - {}", nacionalidade, e.getMessage());
            throw e;
        }
    }
    
    @Override
    public List<Autor> findByNomePessoa(String nome) {
        try {
            log.info("Controller: buscando autor pelo nome: {}", nome);
            return autorService.findByNomePessoa(nome);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao buscar autor pelo nome {} - {}", nome, e.getMessage());
            throw e;
        }
    }
    
    @Override
    public void adicionarLivro(Long autorId, Livro livro) {
        try {
            log.info("Controller: adicionando livro ao autor ID: {}", autorId);
            autorService.adicionarLivro(autorId, livro);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao adicionar livro ao autor id {} - {}", autorId, e.getMessage());
            throw e;
        }
    }

    @Override
    public int contarLivrosPublicados(Long autorId) {
        try {
            log.info("Controller: contando livros publicados do autor ID: {}", autorId);
            return autorService.contarLivrosPublicados(autorId);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao contar livros do autor id {} - {}", autorId, e.getMessage());
            throw e;
        }
    }
    
}

package br.com.ifba.bookboxd.controller;

import br.com.ifba.bookboxd.entity.Autor;
import br.com.ifba.bookboxd.entity.Livro;
import br.com.ifba.bookboxd.service.AutorIService;
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
        log.info("Controller: salvando autor com pessoa: {}", autor.getPessoa().getNome());
        return autorService.save(autor);
    }

    @Override
    public Optional<Autor> findById(Long id) {
        log.info("Controller: buscando autor por ID: {}", id);
        return autorService.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.info("Controller: deletando autor com ID: {}", id);
        autorService.delete(id);
    }

    @Override
    public List<Autor> findAll() {
        log.info("Controller: listando todos os autores");
        return autorService.findAll();
    }

    @Override
    public List<Autor> findByNacionalide(String nacionalidade) {
        log.info("Controller: buscando autores por nacionalidade: {}", nacionalidade);
        return autorService.findByNacionalide(nacionalidade);
    }

    @Override
    public void adicionarLivro(Long autorId, Livro livro) {
        log.info("Controller: adicionando livro '{}' ao autor ID: {}", livro.getTitulo(), autorId);
        autorService.adicionarLivro(autorId, livro);
    }

    @Override
    public int contarLivrosPublicados(Long autorId) {
        log.info("Controller: contando livros do autor ID: {}", autorId);
        return autorService.contarLivrosPublicados(autorId);
    }
    
}

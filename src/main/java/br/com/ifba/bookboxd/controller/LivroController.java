package br.com.ifba.bookboxd.controller;

import br.com.ifba.bookboxd.entity.Avaliacao;
import br.com.ifba.bookboxd.entity.Livro;
import br.com.ifba.bookboxd.service.LivroIService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor 
public class LivroController implements LivroIController {
    
    private final LivroIService livroService;

    @Override
    public Livro save(Livro livro) {
        try{
            log.info("Controller: salvando livro: {}", livro.getTitulo());
            return livroService.save(livro);
        } catch (RuntimeException e){
            log.error("Controller: erro ao salvar livro - {}", e.getMessage());
            throw e;
        }
    }
    
    @Override
    public Livro update(Livro livro) {
        try {
            log.info("Controller: atualizando livro: {}", livro.getTitulo());
            return livroService.update(livro);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao atualizar livro - {}", e.getMessage());
            throw e;
        }
    }
    
    @Override
    public Optional<Livro> findById(Long id) {
        try {
            log.info("Controller: buscando livro por ID: {}", id);
            return livroService.findById(id);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao buscar livro id {} - {}", id, e.getMessage());
            throw e;
        }
    }

    @Override
    public void delete(Long id) {
        try {
            log.info("Controller: deletando livro com ID: {}", id);
            livroService.delete(id);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao deletar livro id {} - {}", id, e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Livro> findAll() {
        try {
            log.info("Controller: listando todos os livros");
            return livroService.findAll();
        } catch (RuntimeException e) {
            log.error("Controller: erro ao listar livros - {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Livro> findByTitulo(String titulo) {
        try {
            log.info("Controller: buscando livros pelo titulo: {}", titulo);
            return livroService.findByTitulo(titulo);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao buscar livros pelo titulo {} - {}", titulo, e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Livro> findByGenero(String genero) {
        try {
            log.info("Controller: buscando livros pelo genero: {}", genero);
            return livroService.findByGenero(genero);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao buscar livros pelo genero {} - {}", genero, e.getMessage());
            throw e;
        }
    }

    @Override
    public double calcularMediaAvaliacoes(Long livroId) {
        try {
            log.info("Controller: calculando media avaliacao livro id: {}", livroId);
            return livroService.calcularMediaAvaliacoes(livroId);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao calcular media do livro id {} - {}", livroId, e.getMessage());
            throw e;
        }
    }

    @Override
    public void adicionarAvaliacao(Long livroId, Avaliacao avaliacao) {
        try {
            log.info("Controller: adicionando avaliacao livro ID: {}", livroId);
            livroService.adicionarAvaliacao(livroId, avaliacao);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao adicionar avaliacao ao livro id {} - {}", livroId, e.getMessage());
            throw e;
        }
    }
}
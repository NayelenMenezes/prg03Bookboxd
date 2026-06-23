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
@Controller // Define esta classe como o controlador que gerencia o fluxo de dados
@RequiredArgsConstructor 
public class LivroController implements LivroIController {
    
    private final LivroIService livroService; // Dependência da camada de serviço

    // Todos os métodos abaixo são uma ponte entre interface gráfica e o LivroService

    @Override
    public Livro save(Livro livro) {
        log.info("Controller: salvando livro: {}", livro.getTitulo());
        return livroService.save(livro);
    }

    @Override
    public Optional<Livro> findById(Long id) {
        log.info("Controller: buscando livro por ID: {}", id);
        return livroService.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.info("Controller: deletando livro com ID: {}", id);
        livroService.delete(id);
    }

    @Override
    public List<Livro> findAll() {
        log.info("Controller: listando todos os livros");
        return livroService.findAll();
    }

    @Override
    public List<Livro> findByTitulo(String titulo) {
         log.info("Controller: buscando livros pelo titulo: {}", titulo);
        return livroService.findByTitulo(titulo);
    }

    @Override
    public List<Livro> findByGenero(String genero) {
         log.info("Controller: buscando livros pelo genero: {}", genero);
        return livroService.findByGenero(genero);
    }

    @Override
    public double calcularMediaAvaliacoes(Long livroId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void adicionarAvaliacao(Long livroId, Avaliacao avaliacao) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
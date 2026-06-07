package br.com.ifba.bookboxd.controller;

import br.com.ifba.bookboxd.entity.Livro;
import br.com.ifba.bookboxd.service.LivroIService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller // Define esta classe como o controlador que gerencia o fluxo de dados
@RequiredArgsConstructor //Cria o construtor automaticamente para injetar o service
public class LivroController implements LivroIController {
    
    private final LivroIService livroService; // Dependência da camada de serviço

    // Todos os métodos abaixo são uma ponte entre interface gráfica e o LivroService

    @Override
    public Livro save(Livro livro) {
        return livroService.save(livro);
    }

    @Override
    public Optional<Livro> findById(Long id) {
        return livroService.findById(id);
    }

    @Override
    public void delete(Long id) {
        livroService.delete(id);
    }

    @Override
    public List<Livro> findAll() {
        return livroService.findAll();
    }

    @Override
    public List<Livro> findByTitulo(String titulo) {
        return livroService.findByTitulo(titulo);
    }

    @Override
    public List<Livro> findByGenero(String genero) {
        return livroService.findByGenero(genero);
    }
}
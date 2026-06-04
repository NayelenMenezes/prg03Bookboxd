package br.com.ifba.bookboxd.controller;

import br.com.ifba.bookboxd.entity.Livro;
import br.com.ifba.bookboxd.service.LivroIService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class LivroController implements LivroIController{
    
    private final LivroIService livroService;

    @Override
    public Livro save(Livro livro) {
        return livroService.save(livro);
    }

    @Override
    public Optional<Livro> findById(Long id) {
        return livroService.findById(id);
    }

    @Override
    public Livro update(Livro livro) {
        return livroService.update(livro);
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

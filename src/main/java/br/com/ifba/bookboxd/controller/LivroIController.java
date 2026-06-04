package br.com.ifba.bookboxd.controller;

import br.com.ifba.bookboxd.entity.Livro;
import java.util.List;
import java.util.Optional;


public interface LivroIController {
    // salva um livro novo
    Livro save(Livro livro);
    
    // busca um livro pelo ID
    Optional<Livro> findById(Long id);
    
    // atualiza um livro existente
    Livro update(Livro livro);
    
    // deleta um livro pelo ID
    void delete(Long id);
    
    // retorna todos os livros cadastrados
    List<Livro> findAll();
    
    // busca livros pelo título
    List<Livro> findByTitulo(String titulo);
    
    // busca livros por gênero
    List<Livro> findByGenero(String genero);
}

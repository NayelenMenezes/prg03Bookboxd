package br.com.ifba.bookboxd.livro.controller;

import br.com.ifba.bookboxd.avaliacao.entity.Avaliacao;
import br.com.ifba.bookboxd.livro.entity.Livro;
import java.util.List;
import java.util.Optional;


public interface LivroIController {
    // salva e atualiza um livro novo
    Livro save(Livro livro);
    
    // atualiza um livro novo
    Livro update(Livro livro);
    
    // busca um livro pelo ID
    Optional<Livro> findById(Long id);
    
    // deleta um livro pelo ID
    void delete(Long id);
    
    // retorna todos os livros cadastrados
    List<Livro> findAll();
    
    // busca livros pelo título
    List<Livro> findByTitulo(String titulo);
    
    // busca livros por gênero
    List<Livro> findByGenero(String genero);
    
    double calcularMediaAvaliacoes(Long livroId);
    
    void adicionarAvaliacao(Long livroId, Avaliacao avaliacao);
}

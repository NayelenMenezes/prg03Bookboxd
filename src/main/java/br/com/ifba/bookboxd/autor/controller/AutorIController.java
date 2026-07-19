package br.com.ifba.bookboxd.autor.controller;

import br.com.ifba.bookboxd.autor.entity.Autor;
import br.com.ifba.bookboxd.livro.entity.Livro;
import java.util.List;
import java.util.Optional;

public interface AutorIController {
    // salva autor
    Autor save(Autor autor);
    
    // atualiza autor
    Autor update(Autor autor);
    
    // busca autor pelo ID
    Optional<Autor> findById(Long id);
    
    // deleta autor pelo ID
    void delete(Long id);
    
    // retorna todos os autores cadastrados
    List<Autor> findAll();
    
    // busca autor pela nacionalidade
    List<Autor> findByNacionalide(String nacionalidade);
    
    List<Autor> findByNomePessoa(String nome);
    
    void adicionarLivro(Long autorId, Livro livro);
    
    int contarLivrosPublicados(Long autorId);
}

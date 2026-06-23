package br.com.ifba.bookboxd.controller;

import br.com.ifba.bookboxd.entity.Editora;
import br.com.ifba.bookboxd.entity.Livro;
import java.util.List;
import java.util.Optional;

public interface EditoraIController {
    // salva e atualiza editora
    Editora save(Editora editora);
    
    // busca uma editora pelo ID
    Optional<Editora> findById(Long id);
    
    // deleta uma editora pelo ID
    void delete(Long id);
    
    // retorna todas as editora cadastrados
    List<Editora> findAll();
    
    // busca editora pelo nome
    List<Editora> findByNome(String nome);
    
    void atualizarDadosContato(Long editoraId, String novoSite);
    
    void adicionarLivro(Long editoraId, Livro livro);
}

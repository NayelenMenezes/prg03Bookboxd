package br.com.ifba.bookboxd.service;

import br.com.ifba.bookboxd.entity.Editora;
import br.com.ifba.bookboxd.entity.Livro;
import java.util.List;
import java.util.Optional;

public interface EditoraIService {
    // salva e atualiza editora
    Editora save(Editora editora);
    
    // busca editora pelo ID
    Optional<Editora> findById(Long id);
    
    // deleta editora pelo ID
    void delete(Long id);
    
    // retorna todas editora cadastradas
    List<Editora> findAll();
    
    //encontra pelo nome
    List<Editora> findByNome(String nome);
    
    void atualizarDadosContato(Long editoraId, String novoSite);
    
    void adicionarLivro(Long editoraId, Livro livro);
}

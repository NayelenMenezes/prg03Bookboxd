package br.com.ifba.bookboxd.service;

import br.com.ifba.bookboxd.entity.Pessoa;
import java.util.List;
import java.util.Optional;


public interface PessoaIService {
    // salva e atualiza pessoa
    Pessoa save(Pessoa pessoa);
    
    // busca uma pessoa pelo ID
    Optional<Pessoa> findById(Long id);
    
    // deleta uma pessoa pelo ID
    void delete(Long id);
    
    // retorna todas as pessoas cadastrados
    List<Pessoa> findAll();
    
    // busca pessoas pelo nome
    List<Pessoa> findByNome(String nome);
    
    int obterIdade(Long pessoaId);
    
   String exibirPerfil(Long pessoaId);
}

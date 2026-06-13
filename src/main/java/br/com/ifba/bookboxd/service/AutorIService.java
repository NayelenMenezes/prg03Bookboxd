package br.com.ifba.bookboxd.service;

import br.com.ifba.bookboxd.entity.Autor;
import java.util.List;
import java.util.Optional;

public interface AutorIService {
    // salva e atualiza autor
    Autor save(Autor autor);
    
    // busca autor pelo ID
    Optional<Autor> findById(Long id);
    
    // deleta autor pelo ID
    void delete(Long id);
    
    // retorna todos os autores cadastrados
    List<Autor> findAll();
    
    // busca autor pela nacionalidade
    List<Autor> findByNacionalide(String nacionalidade);
}

package br.com.ifba.bookboxd.listaleitura.service;

import br.com.ifba.bookboxd.listaleitra.entity.ListaLeitura;
import br.com.ifba.bookboxd.livro.entity.Livro;
import java.util.List;
import java.util.Optional;


public interface ListaLeituraIService {
    // salva e atualiza a lista de leitura
    ListaLeitura save(ListaLeitura lista);
    
    // busca uma lista de leitura pelo ID
    Optional<ListaLeitura> findById(Long id);
    
    // deleta uma lista de leitura pelo ID
    void delete(Long id);
    
    // retorna todas lista de leitura
    List<ListaLeitura> findAll();
    
    List<ListaLeitura> findByUsuarioId(Long usuarioId);
    
    void adicionarLivro(Long listaId, Livro livro);
    
    void removerLivro(Long listaId, Livro livro);
    
    void esvaziarLista(Long listaId);
}

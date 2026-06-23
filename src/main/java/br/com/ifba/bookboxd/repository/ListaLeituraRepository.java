package br.com.ifba.bookboxd.repository;

import br.com.ifba.bookboxd.entity.ListaLeitura;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaLeituraRepository extends JpaRepository<ListaLeitura, Long>{
    //todas as listas de um usuaroi
    List<ListaLeitura> findByUsuarioId(Long usuarioId);
    
    //busca listas pelo nome
    List<ListaLeitura> findByNomeListaContainingIgnoreCase(String nomeLista);
}

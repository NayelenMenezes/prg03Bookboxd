package br.com.ifba.bookboxd.entity;

import br.com.ifba.bookboxd.infrastruture.entity.PersistenceEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "listas_leituras")
@Getter
@Setter
@NoArgsConstructor
public class ListaLeitura extends PersistenceEntity {
    private String nomeLista;
    
    private String descricao;
    
    private List<Livro> listaLivros;
}

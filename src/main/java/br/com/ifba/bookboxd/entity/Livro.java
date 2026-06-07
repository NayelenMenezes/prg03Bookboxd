package br.com.ifba.bookboxd.entity;

import br.com.ifba.bookboxd.infrastruture.entity.PersistenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "livros")
@Getter
@Setter
@NoArgsConstructor
public class Livro extends PersistenceEntity {

    private String titulo;
    
    //Garante que não existirão dois livros com o mesmo número de ISBN no banco
    @Column(unique = true)
    private String isbn;

    private int anoPublicacao;

    private String sinopse;

    private String genero;
}

package br.com.ifba.bookboxd.entity;

import br.com.ifba.bookboxd.infrastruture.entity.PersistenceEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "editoras")
@Getter
@Setter
@NoArgsConstructor
public class Editora extends PersistenceEntity{
    private String nome;
    
    private String site;
    
    private List<Livro> livros;
    
    public void adicionarLivro(Livro livro){
        livros.add(livro);
    }
}

package br.com.ifba.bookboxd.entity;

import br.com.ifba.bookboxd.infrastruture.entity.PersistenceEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "autores")
@Getter
@Setter
@NoArgsConstructor
public class Autor extends PersistenceEntity{
    private String nacionalidade;
    
    private List<Livro> livros;
    
    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;
    
    public void adicionarLivro(Livro livro){
        livros.add(livro);
        livro.setAutor(this);
    }
    
    public int contarLivrosPublicados(){
        if(livros != null){
            return livros.size();
        } else {
            return 0;
        }
    }
}

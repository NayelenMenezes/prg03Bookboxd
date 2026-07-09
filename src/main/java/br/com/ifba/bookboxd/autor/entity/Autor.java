package br.com.ifba.bookboxd.autor.entity;

import br.com.ifba.bookboxd.livro.entity.Livro;
import br.com.ifba.bookboxd.pessoa.entity.Pessoa;
import br.com.ifba.bookboxd.infrastruture.entity.PersistenceEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "autores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"livros", "pessoa"})
public class Autor extends PersistenceEntity{
    @Column(nullable = false)
    private String nacionalidade;
    
    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;
    
    @OneToMany(mappedBy = "autor", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Livro> livros = new ArrayList<>();
    
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

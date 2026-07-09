package br.com.ifba.bookboxd.editora.entity;

import br.com.ifba.bookboxd.livro.entity.Livro;
import br.com.ifba.bookboxd.infrastruture.entity.PersistenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "editoras")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "livros")
public class Editora extends PersistenceEntity{
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String site;
    
    @OneToMany(mappedBy = "editora")
    private List<Livro> livros = new ArrayList<>();
  
    public void atualizarDadosContato(String novoSite){
       this.site = novoSite;
    }
    
    public void adicionarLivro(Livro livro){
        livros.add(livro);
        livro.setEditora(this);
    }
}

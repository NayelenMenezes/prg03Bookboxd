package br.com.ifba.bookboxd.listaleitra.entity;

import br.com.ifba.bookboxd.livro.entity.Livro;
import br.com.ifba.bookboxd.usuario.entity.Usuario;
import br.com.ifba.bookboxd.infrastruture.entity.PersistenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "listas_leituras")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"usuario", "listaLivros"})
public class ListaLeitura extends PersistenceEntity {
    @Column(name = "nome_lista", nullable = false)
    private String nomeLista;
    
    @Column(columnDefinition = "TEXT")
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    
    @ManyToMany
    @JoinTable( name = "lista_livros",
            joinColumns = @JoinColumn(name = "lista_id"),
            inverseJoinColumns = @JoinColumn(name = "livro_id"))
    private List<Livro> listaLivros = new ArrayList<>();
   
    //adiciona livro na lista se ele já não tá lá
    public void adicionarLivro(Livro livro){
        if(!listaLivros.contains(livro)){
            listaLivros.add(livro);
        }
    }
    
    //remove livro da lista
    public void removerLivro(Livro livro){
        listaLivros.remove(livro);
    }
    
    //remove todos os livros da lista
    public void esvaziarLista(){
        listaLivros.clear();
    }
}

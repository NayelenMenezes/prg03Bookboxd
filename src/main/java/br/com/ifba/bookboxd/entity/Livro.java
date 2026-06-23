package br.com.ifba.bookboxd.entity;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Classe entitidade de Livro
@Entity
@Table(name = "livros")
@Getter
@Setter
@NoArgsConstructor
public class Livro extends PersistenceEntity {

    private String titulo;
    
    @Column(unique = true)
    private String isbn;

    private int anoPublicacao;

    private String sinopse;

    private String genero;
    
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;
    
    @ManyToOne
    @JoinColumn(name = "editora_id")
    private Editora editora;
    
    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Avaliacao> avaliacoes = new ArrayList<>();
    
    //calcula a media das notas das avaliações desse livro
    public double calcularMediaAvaliacao(){
        if(avaliacoes == null || avaliacoes.isEmpty()) return 0.0;
        return avaliacoes.stream()
            .mapToInt(Avaliacao::getNota)
            .average()
            .orElse(0.0);
    }
    
    public void adicionarAvaliacao(Avaliacao avaliacao) {
        avaliacoes.add(avaliacao);
        avaliacao.setLivro(this);
    }

}

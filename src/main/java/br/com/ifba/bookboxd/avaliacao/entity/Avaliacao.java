package br.com.ifba.bookboxd.avaliacao.entity;

import br.com.ifba.bookboxd.comentario.entity.Comentario;
import br.com.ifba.bookboxd.livro.entity.Livro;
import br.com.ifba.bookboxd.usuario.entity.Usuario;
import br.com.ifba.bookboxd.infrastruture.entity.PersistenceEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "avaliacoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"usuario", "livro", "comentarios"})
public class Avaliacao extends PersistenceEntity {
    @Column(nullable = false)
    private int nota;
    
    @Column(columnDefinition = "TEXT")
    private String avaliacao;
    
    private LocalDate dataPublicacao;
    
    private boolean contemSpoiler;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "livro_id", nullable = false)
    private Livro livro;
    
    @OneToMany(mappedBy = "avaliacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios = new ArrayList<>();
    
    public void editarTexto(String novoTexo){
        this.avaliacao = novoTexo;
    }
    
    public Comentario adicionarComentario(Usuario autor, String texto){
        Comentario comentario = new Comentario();
        comentario.setUsuario(autor);
        comentario.setTexto(texto);
        comentario.setAvaliacao(this);
        comentario.setDataComentario(LocalDate.now());
        this.comentarios.add(comentario);
        return comentario;
    }
    
    public void toggleSpoiler(){
        this.contemSpoiler = !this.contemSpoiler;
    }
}

package br.com.ifba.bookboxd.entity;

import br.com.ifba.bookboxd.infrastruture.entity.PersistenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "comentarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"usuario", "avaliacao"})
public class Comentario extends PersistenceEntity {
    @Column(columnDefinition = "TEXT", nullable = false)
    private String texto;
    
    private LocalDate dataComentario;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "avaliacao_id", nullable = false)
    private Avaliacao avaliacao;
    
    public boolean validarConteudo() {
        return texto != null && !texto.isBlank();
    }
    
    public void editarTexto(String novoTexto) {
        this.texto = novoTexto;
    }
}

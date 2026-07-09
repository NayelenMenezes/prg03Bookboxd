package br.com.ifba.bookboxd.pessoa.entity;

import br.com.ifba.bookboxd.infrastruture.entity.PersistenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.Period;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "pessoas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pessoa extends PersistenceEntity {
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;
    
    @Column(name= "biografia", columnDefinition = "TEXT")
    private String biografia;
    
    public int obterIdade(){
        if(dataNascimento == null) return 0;
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }
    
    public String exibirPerfil(){
        return String.format(
                "Nome: %s | Idade: %d anos| Biografia: %s",
                nome != null ? nome: "Não informado",
                obterIdade(),
                biografia != null ? biografia : "Sem biografia"
        );
    }
}

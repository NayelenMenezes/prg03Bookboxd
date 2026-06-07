package br.com.ifba.bookboxd.infrastruture.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass //Indica que esta classe não será uma tabela
public class PersistenceEntity {
    
    @Id//Define que este atributo é a chave primária da tabela no banco de dado
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
}

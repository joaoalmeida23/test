package br.com.back.test.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@ToString
@Data
@Builder
@AllArgsConstructor
public class Task {
    @Id
    private Long idTask;
    private String departamento;
    private String tituloDaTask;
    private String prazo;
    private String descrição;
    private Boolean finalizado;


    @ManyToOne
    private Users users;

    public boolean isFinalizado(){
        return finalizado;
    }
}

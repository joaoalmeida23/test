package br.com.back.test.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    private String name;
    private String departamento;
    private String listaDeTarefas;


}

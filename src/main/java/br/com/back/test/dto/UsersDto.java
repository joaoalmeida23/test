package br.com.back.test.dto;


import br.com.back.test.model.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class UsersDto {

    private String departamento;
    private String name;
    private String listaDeTarefas;


    public UsersDto(Users users){
        this.departamento = users.getDepartamento();
        this.name = users.getName();
        this.listaDeTarefas = users.getListaDeTarefas();
    }

    public Users convert(UsersDto dto){
        return Users.builder().departamento(departamento).name(name).listaDeTarefas(listaDeTarefas).build();
    }
}

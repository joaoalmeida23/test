package br.com.back.test.dto;

import br.com.back.test.model.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class TaskDto {

    private Long idTask;
    private String departamento;
    private String tituloDaTask;
    private String dataDeEntrega;
    private UsersDto usersDto;

    public TaskDto(Task task){
        this.idTask = task.getIdTask();
        this.departamento = task.getDepartamento();
        this.tituloDaTask = task.getTituloDaTask();
        this.dataDeEntrega = task.getPrazo();
    }

    public Task convert(TaskDto taskDto){
        return Task.builder().idTask(idTask).departamento(departamento).tituloDaTask(tituloDaTask).prazo(dataDeEntrega).build();
    }
}

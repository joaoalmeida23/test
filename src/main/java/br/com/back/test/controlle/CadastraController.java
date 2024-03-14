package br.com.back.test.controlle;


import br.com.back.test.dto.TaskDto;
import br.com.back.test.dto.UsersDto;
import br.com.back.test.model.Task;
import br.com.back.test.model.Users;
import br.com.back.test.repository.TaskRepository;
import br.com.back.test.repository.UsersRepository;
import br.com.back.test.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Tarefas")
public class CadastraController {

    @Autowired
    private TaskRepository taskRepository;
    private UsersRepository usersRepository;

    @Autowired
    private UsersService usersService;

    @PostMapping("/cadastrar")
        public ResponseEntity<TaskDto> cadastra(@RequestBody TaskDto dto){
        usersService.serviceCadastra(dto);
        return ResponseEntity.ok().build();

    }

    @PutMapping("/alterar/{task}")
    public ResponseEntity<TaskDto> alterar(@PathVariable String name, @RequestBody @Valid TaskDto taskDto){
        Task task = usersService.atualizar(taskDto);
        return ResponseEntity.ok(new TaskDto(task));

    }

    @DeleteMapping("/{users}")
    public ResponseEntity<Long> remover(@PathVariable Long idTask){
        usersService.remover(idTask);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/tarefas/finalizar/{id}")
    public ResponseEntity<String> finalizarTarefa(@PathVariable Long id) {

        boolean tarefaFinalizada = usersService.finalizarTarefa(id);

        if (tarefaFinalizada) {
            return ResponseEntity.ok("Tarefa finalizada com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}

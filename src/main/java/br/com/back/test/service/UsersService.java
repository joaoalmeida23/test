package br.com.back.test.service;


import br.com.back.test.dto.TaskDto;
import br.com.back.test.model.Task;
import br.com.back.test.repository.TaskRepository;
import br.com.back.test.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UsersService {

    private UsersRepository usersRepository;
    private TaskRepository taskRepository;


    @Autowired
   public UsersService(UsersRepository usersRepository, TaskRepository taskRepository){

       this.usersRepository = usersRepository;
       this.taskRepository = taskRepository;
   }

   public Task serviceCadastra(TaskDto dto){

        Task task = dto.convert(dto);
        return taskRepository.save(task);
   }

   public Task atualizar(TaskDto dto){

        Task task = dto.convert(dto);

        return taskRepository.save(task);
   }

   public void remover(Long id){
        taskRepository.deleteById(id);
   }


    public boolean finalizarTarefa(Long id) {
        // Lógica para finalizar a tarefa com o ID fornecido
        // Aqui você pode acessar o repositório para buscar a tarefa pelo ID e atualizar o status para finalizado
        Optional<Task> optionalTask = taskRepository.findById(id);

        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setFinalizado(true);
            taskRepository.save(task);
            return true;
        } else {
            return false; // Tarefa não encontrada
        }
    }
}

package ru.gb.springhw5.controller;
import jakarta.transaction.Status;
import org.springframework.web.bind.annotation.*;
import ru.gb.springhw5.TaskRepository;
import ru.gb.springhw5.model.Task;
import lombok.AllArgsConstructor;
import ru.gb.springhw5.model.TaskStatus;
import java.util.List;

@AllArgsConstructor
//@RestController
@RequestMapping("/tasks")
public class TaskController {
    private TaskRepository taskRepository;

    @GetMapping                             //Просмотр всех задач
    public List<Task> getAllTasks(){
        return taskRepository.findAll(); }

    @PostMapping                            //Добавление задачи
    public Task addTask(@RequestBody Task task){
        return taskRepository.save(task); }

    @GetMapping("/status/{status}")         //Просмотр задач по статусу
    public List<Task> getTasksByStatus(@PathVariable Status status) {
        return taskRepository.findByStatus(status); }

    @PutMapping("/{id}")                    //Изменение статуса задачи
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        Task current = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id " + id));
        task.setStatus(task.getStatus());
        return taskRepository.save(current);
    }

    @DeleteMapping("/{id}")                 //Удаление задачи
    public void deleteTask(@PathVariable Long id){
        taskRepository.deleteById(id); }
}



package com.tony.gestionnairedetache.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.tony.gestionnairedetache.exception.TaskNotFoundException;
import com.tony.gestionnairedetache.model.Task;
import com.tony.gestionnairedetache.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task getTask(long id){ 
        return taskRepository.findById(id)
                                .orElseThrow(() -> new TaskNotFoundException(id)) ;
    }
}
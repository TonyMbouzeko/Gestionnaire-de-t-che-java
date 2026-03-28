package com.tony.gestionnairedetache.service;

import org.springframework.stereotype.Service;
import java.util.List;

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
}
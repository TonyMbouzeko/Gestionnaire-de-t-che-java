package com.tony.gestionnairedetache.service;

import com.tony.gestionnairedetache.model.Task;
import com.tony.gestionnairedetache.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    void shouldReturnAllTasks() {
        Task task1 = new Task();
        task1.setId(1L);
        task1.setDescription("Task 1");
        task1.setCompleted(false);

        Task task2 = new Task();
        task2.setId(2L);
        task2.setDescription("Task 2");
        task2.setCompleted(true);

        when(taskRepository.findAll()).thenReturn(List.of(task1, task2));

        List<Task> tasks = taskService.getAllTasks();

        assertEquals(2, tasks.size());
        assertEquals("Task 1", tasks.get(0).getDescription());
        assertEquals("Task 2", tasks.get(1).getDescription());
    }

@Test
void shouldCreateTask() {
    Task task = new Task();
    task.setDescription("tacheTest");
    task.setCompleted(false);

    Task savedTask = new Task();
    savedTask.setId(1L);
    savedTask.setDescription("tacheTest");
    savedTask.setCompleted(false);

    when(taskRepository.save(task)).thenReturn(savedTask);

    Task result = taskService.createTask(task);

    assertEquals(1L, result.getId());
    assertEquals("tacheTest", result.getDescription());
    assertEquals(false, result.isCompleted());
}

@Test
void shouldDeleteTaskById() {
    Long id = 1L;

    taskService.deleteTask(id);

    verify(taskRepository).deleteById(id);
}
}
package com.tony.gestionnairedetache.controller;

import com.tony.gestionnairedetache.TaskController;
import com.tony.gestionnairedetache.model.Task;
import com.tony.gestionnairedetache.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;

    @Test
    void shouldReturnAllTasks() throws Exception {

        Task task1 = new Task();
        task1.setId(1L);
        task1.setDescription("Task 1");
        task1.setCompleted(false);

        Task task2 = new Task();
        task2.setId(2L);
        task2.setDescription("Task 2");
        task2.setCompleted(true);

        when(taskService.getAllTasks()).thenReturn(List.of(task1, task2));

        mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].description").value("Task 1"))
                .andExpect(jsonPath("$[1].description").value("Task 2"));
    }

@Test
void shouldCreateTask() throws Exception {

    Task createdTask = new Task();
    createdTask.setId(1L);
    createdTask.setDescription("Test de création de tâche");
    createdTask.setCompleted(false);

    when(taskService.createTask(any(Task.class))).thenReturn(createdTask);

    mockMvc.perform(post("/tasks")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""
                            {
                                "description": "Test de création de tâche",
                                "completed": false
                            }
                            """))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.description").value("Test de création de tâche"))
            .andExpect(jsonPath("$.completed").value(false));
}

@Test
void shouldDeleteTask() throws Exception {
    Long id = 1L;

    mockMvc.perform(delete("/tasks/{id}", id))
            .andExpect(status().isNoContent());

    verify(taskService).deleteTask(id);
}

}
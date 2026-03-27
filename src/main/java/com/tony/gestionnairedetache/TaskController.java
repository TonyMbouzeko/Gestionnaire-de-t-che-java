package com.tony.gestionnairedetache;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")

public class TaskController {

    private TaskManager taskManager = new TaskManager();

    @GetMapping
    public List<Task> getTasks() {
        return taskManager.getTasks();
    }

    @PostMapping
    public void addTask(@RequestBody Task task){
        taskManager.addTask(task);
    }

    

}

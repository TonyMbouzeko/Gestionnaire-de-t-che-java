package com.tony.gestionnairedetache.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tony.gestionnairedetache.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
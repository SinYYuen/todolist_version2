package org.generation.todolist.repository.entity;

import org.springframework.data.repository.CrudRepository;

public interface ToDoListRepository extends CrudRepository<ToDoList, Integer> {
}

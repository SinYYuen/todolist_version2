package org.generation.todolist.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.generation.todolist.controller.dto.ToDoListDTO;


@Entity
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;
    private String date;

    public ToDoList(){

    }

    public ToDoList(ToDoListDTO todolistDTO){

        this.title = todolistDTO.getTitle();
        this.description = todolistDTO.getDescription();
        this.date = todolistDTO.getDate();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString()
    {
        return "Customer{" + "id=" + id + ", title='" + title + '\'' + ", description='" +
                description + '}';
    }

}


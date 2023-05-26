package org.generation.todolist.controller;

import org.generation.todolist.controller.dto.ToDoListDTO;
import org.generation.todolist.repository.entity.ToDoList;
import org.generation.todolist.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/todolist")
public class ToDoListController {

    private final ToDoListService todolistservice;


    public ToDoListController(@Autowired ToDoListService todolistservice){

        this.todolistservice = todolistservice;
    }

    @CrossOrigin
    @GetMapping("/all")
    public Iterable<ToDoList> getToDoList(){

        return todolistservice.all();
    }

    @CrossOrigin
    @PostMapping("/add")
    public void save(  @RequestParam(name="title", required = true) String title,
                       @RequestParam(name="description", required = true) String description,
                       @RequestParam(name="targetDate", required = true) String targetDate)

    {

        ToDoListDTO todolistDTO = new ToDoListDTO(title, description, targetDate);
        this.todolistservice.save(new ToDoList(todolistDTO));
    }



}

package org.generation.todolist.service;

import org.generation.todolist.repository.entity.ToDoList;
import org.generation.todolist.repository.entity.ToDoListRepository;
import org.generation.todolist.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoListServiceMySQL implements ToDoListService {

    private final ToDoListRepository todolistRepository;

    //Dependency Injection of another class object to this class object can be done with
    // @Autowired annotation


    public ToDoListServiceMySQL(@Autowired ToDoListRepository todolistRepository)
    {
        this.todolistRepository = todolistRepository;
    }


    @Override
    public ToDoList save(ToDoList todolist)
    {
        //since we have done the dependency injection we can now call any method from CRUDRepository

        return this.todolistRepository.save(todolist);
    }



    @Override
    public ArrayList<ToDoList> all()
    {
        ArrayList<ToDoList> result = new ArrayList<>();
        this.todolistRepository.findAll().forEach(result::add);

        return result;
    }


    @Override
    public void delete(int ToDoListId)
    {
        this.todolistRepository.deleteById(ToDoListId);
    }



    @Override
    public ToDoList findById(int ToDoListId)
    {

        //Optional is a list that accepts either a null(empty), or with item
        Optional<ToDoList> customer = this.todolistRepository.findById(ToDoListId);
        ToDoList customerResponse = customer.get();
        return customerResponse;
    }



}

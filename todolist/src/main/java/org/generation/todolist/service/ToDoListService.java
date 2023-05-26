package org.generation.todolist.service;

import org.generation.todolist.repository.entity.ToDoList;

import java.util.ArrayList;

public interface ToDoListService {


    //save method is for 2 purposes - Create new item & Update existing item
    ToDoList save(ToDoList todolist);


    //Read all customer from database
    ArrayList<ToDoList> all();


    //Delete customer from database - based on customer Id
    void delete(int customerId);

    //find customer from database - based on customer Id
    public ToDoList findById(int customerId);
}

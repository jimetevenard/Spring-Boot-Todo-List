package com.example.demototo.rest;

import com.example.demototo.model.Todo;
import com.example.demototo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/todo")
public class TodoResource {

    @Autowired
    private TodoService service;

    @GetMapping("/all")
    public List<Todo> allTodo(){
        return service.getAllTodo();
    }
}

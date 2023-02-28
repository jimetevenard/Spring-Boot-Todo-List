package com.example.demototo.service;

import com.example.demototo.data.TodoRepository;
import com.example.demototo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodo(){
        return todoRepository.findAll().stream()
                .map(todoEntity -> new Todo(todoEntity.getId(), todoEntity.getLabel(), todoEntity.isDone()))
                .collect(Collectors.toList());
    }
}

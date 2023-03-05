package com.example.demototo.service;

import com.example.demototo.data.TodoEntity;
import com.example.demototo.data.TodoRepository;
import com.example.demototo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    private static final boolean IS_NOT_DONE = false;

    public List<Todo> getAllTodo(){
        return todoRepository.findAll().stream()
                .map(this::mapEntityToDto)
                .toList();
    }

    public List<Todo> getUndoneTodo(){
        return todoRepository.findByDone(IS_NOT_DONE).stream()
                .map(this::mapEntityToDto)
                .toList();
    }

    public int countUndoneTodo(){
        return todoRepository.countByDone(IS_NOT_DONE);
    }

    private Todo mapEntityToDto(TodoEntity todoEntity) {
        return new Todo(todoEntity.getId(), todoEntity.getLabel(), todoEntity.isDone());
    }
}

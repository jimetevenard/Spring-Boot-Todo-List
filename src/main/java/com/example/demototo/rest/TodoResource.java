package com.example.demototo.rest;

import com.example.demototo.model.Todo;
import com.example.demototo.service.TodoService;

import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/todo")
public class TodoResource {

    @Autowired
    private TodoService service;

    /**
     * Récupère tous les TODOs, qu'ils soient DONE ou non.
     * @return
     */
    
    @GetMapping("/all")
    public List<Todo> allTodo(){
        return service.getAllTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable("id") long id) {
        Optional<Todo> todoOptional = service.getTodo(id);
        if(todoOptional.isPresent()){
            return new ResponseEntity<Todo>(todoOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Todo>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/undone")
    public List<Todo> undoneTodo(){
        return service.getUndoneTodo();
    }

    @GetMapping("/undone/count")
    public int countUndoneTodo(){
        return service.countUndoneTodo();
    }
}

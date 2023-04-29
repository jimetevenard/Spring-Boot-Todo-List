package com.example.demototo.service;

import com.example.demototo.model.Todo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


/**
 * La base h2 et le jeu de données data.sql seront utilisés pour ce test
 */
@SpringBootTest // <= Inject les Beans (Contexte de test)
public class TodoServiceTest {

    @Autowired
    private TodoService todoService;

    @Test
    public void allTodosGetAllTodos(){
        Assertions.assertEquals(2, todoService.getAllTodo().size());
    }

    @Test
    public void undoneTodosGetUnedoneTodos(){
        List<Todo> actualUndone = todoService.getUndoneTodo();
        Assertions.assertEquals(1, actualUndone.size());
        Assertions.assertFalse(actualUndone.get(0).done());
    }

    @Test
    public void countTodosGivesTheNumberofTodos(){
        Assertions.assertEquals(1, todoService.countUndoneTodo());
    }
}

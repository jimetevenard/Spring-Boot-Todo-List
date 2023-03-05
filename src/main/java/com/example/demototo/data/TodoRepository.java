package com.example.demototo.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

    List<TodoEntity> findByDone(boolean done);
    int countByDone(boolean done);
}

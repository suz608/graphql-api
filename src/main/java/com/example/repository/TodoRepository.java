package com.example.repository;
import com.example.entity.Status;
import com.example.entity.Todo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findByStatus(Status status);
}

package ru.gb.springhw5;
import jakarta.transaction.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.springhw5.model.Task;

import java.util.List;
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
        public List<Task> findByStatus(Status status);
}

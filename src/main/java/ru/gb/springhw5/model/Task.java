package ru.gb.springhw5.model;
import jakarta.persistence.*;
import jakarta.transaction.Status;
import lombok.Data;
import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;

@Data
@Entity
@Table (name = "tasks")
public class Task {
    //- ID (автоинкрементное)(тип Long)
// - Описание (не может быть пустым)(тип String)
// - Статус (одно из значений: "не начата", "в процессе", "завершена")(Тип TaskStatus )
// - Дата создания (автоматически устанавливается при создании задачи)(Тип LocalDateTime)
//
//    Подсказка понадобится энумератор:
//    enum TaskStatus {
//        NOT_STARTED, IN_PROGRESS, COMPLETED;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column (nullable = false)
    private String title;
    private String description;
    @Column
    @Enumerated
    private TaskStatus status;

    @Column
    private LocalDateTime timeOfCreation = LocalDateTime.now();
}



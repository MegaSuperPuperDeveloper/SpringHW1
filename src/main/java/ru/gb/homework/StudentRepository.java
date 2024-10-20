package ru.gb.homework;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class StudentRepository {

    private final List<Student> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
        students.add(new Student("Igor", "Первая"));
        students.add(new Student("Nikolay", "Первая"));
        students.add(new Student("Dmitriy", "Вторая"));
        students.add(new Student("Artem", "Вторая"));
        students.add(new Student("Alexander", "Третья"));
    }

    public List<Student> getAll() {
        return List.copyOf(students);
    }

    public Student getByName(String name) {
        return students.stream()
                .filter(it -> Objects.equals(it.getName(), name))
                .findFirst()
                .orElse(null);
    }

    public Student getById(long id) {
        return students.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public boolean delete(Long id) {
        return students.removeIf(it -> Objects.equals(it.getId(), id));
    }

}

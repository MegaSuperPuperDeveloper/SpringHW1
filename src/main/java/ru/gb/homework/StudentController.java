package ru.gb;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.homework.Student;
import ru.gb.homework.StudentRepository;

import java.util.List;

//@Controller
@RestController
@RequestMapping("/students")
public class StudentController {

    // PUT    /users/{id}  {"id": "1", "name": "newName"} - изменение

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/test")
    public String test() {
        return """
      <h1>Title</h1>
      """;
    }

    @GetMapping("/all")
    public List<Student> getStudents() {
        return repository.getAll();
    }

    @GetMapping(value = "/get{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> getUser(@PathVariable long id) {
        Student student = repository.getById(id);
        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // 404
        }
        return ResponseEntity.ok(student); // 200
    }

    @GetMapping(value = "/del{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> delUser(@PathVariable long id) {
        Student student = repository.getById(id);
        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        repository.delete(id);
        return ResponseEntity.ok(getStudents());
    }

    @GetMapping
    public Student getUserByName(@RequestParam String name) {
        return repository.getByName(name);
    }

//  @PatchMapping("/update{id}")
//  public User updateUser(@PathVariable long id, @RequestBody User user) {
//    User existsUser = repository.getById(id);
//    if (existsUser == null) { // 404
//      throw new IllegalArgumentException();
//    }
//
//    existsUser.setName(user.getName());
//    return existsUser;
//  }

}

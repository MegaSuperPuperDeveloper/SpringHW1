package ru.gb;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
@RequestMapping("/users")
public class UserController {

  // REST
  // GET /users/{id} => 404 (Not Found)
  // GET /users?nameLike='Igor%' => 204 (No Content)

  // DELETE /users/{id} - удаляет
  // POST   /users/      {"id": "1", "name": "newName"} - создает
  // PUT    /users/{id}  {"id": "1", "name": "newName"} - изменение

  // HTTP HyperText Transfer Protocol
  // GET POST PUT PATCH DELETE ... HEAD OPTIONS

  // http://ip-address/users/all -> List<User>
  // http://ip-address/users/1 -> User(1, Igor)
  // http://ip-address/users?name=Igor -> User(1, Igor)

  private final UserRepository repository;

  public UserController(UserRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/test")
  public String test() {
    return """
      <h1>Title</h1>
      """;
  }

  @GetMapping("/all")
  public List<User> getUsers() {
    return repository.getAll();
  }

  @GetMapping(value = "/get{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<User> getUser(@PathVariable long id) {
    User user = repository.getById(id);
    if (user == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // 404
    }
    return ResponseEntity.ok(user); // 200
  }

  @GetMapping(value = "/del{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<User>> delUser(@PathVariable long id) {
    User user = repository.getById(id);
    if (user == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    repository.delete(id);
    return ResponseEntity.ok(getUsers());
  }

  @GetMapping
  public User getUserByName(@RequestParam String name) {
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

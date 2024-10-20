package ru.gb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * 1. Создать spring-boot приложение с помощью https://start.spring.io/
 * 2. Создать Класс Student c полями: идентификатор, имя, имя группы
 * 3. Создать контроллер, обрабатывающий входящие запросы:
 * 3.1 GET /student/{id} - получить студента по ID
 * 3.2 GET /student - получить всех студентов
 * 3.3 GET /student/search?name='studentName' - получить список студентов, чье имя содержит подстроку studentName
 * 3.4 GET /group/{groupName}/student - получить всех студентов группы
 * 3.5 POST /student - создать студента (принимает JSON) (отладиться можно с помощью Postman)
 * 3.6 DELETE /student/{id} - удалить студента
 * 4. При старте приложения, в программе должно быть создано 5-10 студентов.
 */


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);

//		UserRepository userRepository = (UserRepository) context.getBean("myUserRepository");
//		UserRepository userRepository11 = context.getBean("myUserRepositoryBean", UserRepository.class);

//		UserRepository userRepository1 = context.getBean(UserRepository.class);
//		UserRepository userRepository2 = context.getBean(UserRepository.class);
//		UserRepository userRepository3 = context.getBean(UserRepository.class);
//
//		System.out.println(userRepository == userRepository1);
//
//		System.out.println(userRepository1 == userRepository2);
//		System.out.println(userRepository1 == userRepository3);
//		System.out.println(userRepository2 == userRepository3);

//		UserRepository userRepository = new UserRepository();
//		System.out.println(userRepository.getAll());
//		System.out.println(userRepository.getById(2));
	}

}

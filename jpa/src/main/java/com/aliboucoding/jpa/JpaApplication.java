package com.aliboucoding.jpa;

import com.aliboucoding.jpa.Specification.AuthorSpecification;
import com.aliboucoding.jpa.models.Author;
import com.aliboucoding.jpa.models.Video;
import com.aliboucoding.jpa.repositories.AuthorRepository;
import com.aliboucoding.jpa.repositories.VideoRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthorRepository repository,
			VideoRepository videoRepository

	){
		return args -> {
//			for(int i = 0 ; i < 50 ; i++){
//				Faker faker= new Faker();
//				var author = Author.builder()
//						.firstName(faker.name().firstName())
//						.lastName(faker.name().lastName())
//						.age(faker.number().numberBetween(19, 80))
//						.email(faker.name().username()+"@aliboucoding.com")
//						.build();
//				repository.save(author);
//			}

			// update author with ID = 1
			var author  = Author.builder()
					.id(1)
					.firstName("ali")
					.lastName("alibou")
					.age(34)
					.email("ali@gmail.com")
					.build();
			// repository.save(author);

			// update Author a seta a.age = 22 where a.id= 1
			repository.updateAuthor(22, 1);
			// update all authors
			// repository.updateAuthorsAge(99);

			// find by named query
//			repository.findByNamedQuery(22)
//					.forEach(System.out::println);
//
//			repository.updateByNamedQuery(12);

			Specification<Author> spec = Specification
					.where(AuthorSpecification.hasAge(22))
					.or(AuthorSpecification.firstnameLike("ch"));
			repository.findAll(spec).forEach(System.out::println);



			/* var author = Author.builder()
					.firstName("alibou")
					.lastName("alibou")
					.age(34)
					.email("ali@gmail.com")
					.build();
			repository.save(author); */


			/* var video = Video.builder()
					.name("abe")
					.length(5)
					.build();
			videoRepository.save(video); */


		};

	}
}

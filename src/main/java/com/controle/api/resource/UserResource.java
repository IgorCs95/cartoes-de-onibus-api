package com.controle.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controle.api.entities.User;
import com.controle.api.event.RecursoCriarEvent;
import com.controle.api.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserResource {


	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<User> create(@Validated @RequestBody User user, HttpServletResponse response) {

		User user1 = userRepository.save(user);

		publisher.publishEvent(new RecursoCriarEvent(this, response, user1.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getId(@PathVariable Long id) {

		return userRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.noContent().build());
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@Validated @PathVariable long id, @RequestBody User user) {

		return userRepository.findById(id).map(record -> {
			record.setNome(user.getNome());
			record.setEmail(user.getEmail());
			record.setSenha(user.getSenha());

			User updated = userRepository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		return userRepository.findById(id).map(record -> {
			userRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}

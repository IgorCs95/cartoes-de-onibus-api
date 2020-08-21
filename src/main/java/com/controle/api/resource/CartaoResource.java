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

import com.controle.api.entities.Cartao;
import com.controle.api.event.RecursoCriarEvent;
import com.controle.api.repository.CartaoRepository;
import com.controle.api.repository.filter.CartaoFilter;

@RestController
@RequestMapping("/cartao")
public class CartaoResource {

	@Autowired
	private CartaoRepository cartaoRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Cartao> getAll(CartaoFilter cartaoFilter) {
		return cartaoRepository.filtrar(cartaoFilter);
	}

	@PostMapping
	public ResponseEntity<?> create(@Validated @RequestBody Cartao cartao, HttpServletResponse response) {
		
		if(!cartaoRepository.existsById(cartao.getNumeroCartao())) {
			Cartao c = cartaoRepository.save(cartao);
			publisher.publishEvent(new RecursoCriarEvent(this, response, c.getNumeroCartao()));
			return ResponseEntity.status(HttpStatus.CREATED).body(c);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cartao> getId(@PathVariable Long id) {

		return cartaoRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.noContent().build());
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Cartao> update(@Validated @PathVariable long id, @RequestBody Cartao cartao) {

		return cartaoRepository.findById(id).map(record -> {
			record.setStatus(cartao.isStatus());

			Cartao updated = cartaoRepository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		return cartaoRepository.findById(id).map(record -> {
			cartaoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}

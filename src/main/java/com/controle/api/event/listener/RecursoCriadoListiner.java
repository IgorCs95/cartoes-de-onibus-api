package com.controle.api.event.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.controle.api.event.RecursoCriarEvent;

@Component
public class RecursoCriadoListiner implements ApplicationListener<RecursoCriarEvent>{



	@Override
	public void onApplicationEvent(RecursoCriarEvent event) {
		HttpServletResponse response = event.getResposne();
		Long codigo = event.getCodigo();
		
		addHeaderLocation(response, codigo);
		
	}

	private void addHeaderLocation(HttpServletResponse response, Long codigo) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}").buildAndExpand(codigo)
				.toUri();
		
		response.setHeader("Lacation", uri.toASCIIString());
	}
	
	

}

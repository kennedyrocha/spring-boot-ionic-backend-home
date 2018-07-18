package com.kennedy.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kennedy.cursomc.domain.Pedido;
import com.kennedy.cursomc.repositories.PedidoRepository;
import com.kennedy.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		
		Optional<Pedido> obj = repo.findById(id);

		return obj.orElseThrow(() ->  new ObjectNotFoundException("Objeto não encontrado id: " + id
												+ ", Tipo: " + Pedido.class.getName()));
		
	}

}

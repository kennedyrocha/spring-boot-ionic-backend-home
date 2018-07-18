package com.kennedy.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.kennedy.cursomc.domain.Categoria;
import com.kennedy.cursomc.repositories.CategoriaRepository;
import com.kennedy.cursomc.services.exceptions.DataIntegrityException;
import com.kennedy.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		
		Optional<Categoria> obj = repo.findById(id);

		return obj.orElseThrow(() ->  new ObjectNotFoundException("Objeto não encontrado id: " + id
												+ ", Tipo: " + Categoria.class.getName()));
		
	}
	
	public Categoria insert(Categoria obj) {

		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete (Integer id) {
		
		this.find(id);
		
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			
			throw new DataIntegrityException("Não possível excluir uma categoria que possui produtos");
		}
	}
	
	public List<Categoria> findAll(){
		
		return repo.findAll();
	}

}

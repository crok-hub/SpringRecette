package org.cro.springrecette.services;

import java.util.Collection;

import org.cro.springrecette.models.Ingredient;
import org.cro.springrecette.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {
	
	@Autowired
	private IngredientRepository repository;

	public Collection<Ingredient> getAll() {
		return this.repository.findAll();
	}

	public Ingredient findById(String id) {
		return this.repository.findById(id).orElse(null);
	}

	public Collection<Ingredient> findByName(String name) {
		return this.repository.findByNameAllIgnoreCase(name);
	}

}

package org.cro.springrecette.services;

import java.util.Collection;

import org.cro.springrecette.models.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {
	
	@Autowired
	private MongoRepository<Ingredient, String> repository;

	public Collection<Ingredient> getAll() {
		return this.repository.findAll();
	}

	public Ingredient findById(String id) {
		return this.repository.findById(id).orElse(null);
	}

}

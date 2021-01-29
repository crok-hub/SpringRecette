package org.cro.springrecette.repositories;

import java.util.List;

import org.cro.springrecette.models.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IngredientRepository extends MongoRepository<Ingredient, String> {

	public List<Ingredient> findAll();
	
	public Ingredient findById();

}

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

	/**
	 * Toute la liste des ingredients.
	 * 
	 * @return tous les ingredients
	 */
	public Collection<Ingredient> getAll() {
		return this.repository.findAll();
	}

	/**
	 * Retrouve un ingredient par son identifiant unique.
	 * 
	 * @param id non null
	 * @return l'ingredient identifié par ID, null sinon
	 */
	public Ingredient findById(String id) {
		return this.repository.findById(id).orElse(null);
	}
	
	/**
	 * Retrouve un ingrédient identifié par son nom
	 * 
	 * @param name non null
	 * @return une liste ingrédient identifié par nom, null sinon
	 */
	public Collection<Ingredient> findByName(String name) {
		return this.repository.findByNameAllIgnoreCase(name);
	}
	
	/**
	 * Enregistre un ingredient, s'il n'existe déjà pas.
	 * Identification par nom.
	 * 
	 * @param ingredient non null
	 * @return l'ingrdient avec son identifiant ID, null sinon
	 */
	public Ingredient save(Ingredient ingredient) {
		Collection<Ingredient> existing = this.findByName(ingredient.getName());
		if (existing.isEmpty()) return this.repository.save(ingredient);
		return null;
	}

}

package org.cro.springrecette.controlers;

import java.util.Collection;

import org.cro.springrecette.models.Ingredient;
import org.cro.springrecette.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ingredients")
public class IngredientControler {

	@Autowired
	private IngredientService service;

	@GetMapping
	public ResponseEntity<Collection<Ingredient>> ingredients() {
		Collection<Ingredient> ingredients = this.service.getAll();
		if (ingredients.isEmpty())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(ingredients);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Ingredient> findById(@PathVariable String id) {
		Ingredient ingredient = this.service.findById(id);
		if (ingredient == null) 
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(ingredient);
	}
	
	@GetMapping("/nom/{name}")
	public ResponseEntity<Collection<Ingredient>> findByName(@PathVariable String name) {
		Collection<Ingredient> ingredients = this.service.findByName(name);
		if (ingredients.isEmpty()) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(ingredients);
	}
	
	@PostMapping
	public ResponseEntity<Ingredient> save(@RequestBody Ingredient ingredient) {
		Ingredient saved = this.service.save(ingredient);
		if (saved == null) 
			return ResponseEntity.unprocessableEntity().build();
		return ResponseEntity.ok(saved);
	}
	
}

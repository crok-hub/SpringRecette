package org.cro.springrecette.models;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("ingredient")
public class Ingredient {
	
	@Id
	private String id;
	
	private String name;
	private int quantity;
	private String unit;
	
	public Ingredient() {}
	
	public Ingredient(String name, int quantity, String unit) {
		this.name = name;
		this.quantity = quantity;
		this.unit = unit;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingredient other = (Ingredient) obj;
		return Objects.equals(this.name, other.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.name);
	}
	
	
}

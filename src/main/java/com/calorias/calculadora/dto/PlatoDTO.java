package com.calorias.calculadora.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoDTO {
    private String name;
    private List<IngredienteDTO> ingredients;
    private Double calories;
    private IngredienteDTO moreCaloriesIngredient;

    public PlatoDTO(String nombre, List<IngredienteDTO> ingredientes) {
        this.name = nombre;
        this.ingredients = ingredientes;
        this.calories = 0.0;
        this.moreCaloriesIngredient = new IngredienteDTO();
    }
}

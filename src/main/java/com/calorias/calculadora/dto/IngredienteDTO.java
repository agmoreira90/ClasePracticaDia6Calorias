package com.calorias.calculadora.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredienteDTO {

    private String name;
    private Double weight;
    private Double calories;

    public IngredienteDTO(String name, Double weight) {
        this.name = name;
        this.weight = weight;
    }
}


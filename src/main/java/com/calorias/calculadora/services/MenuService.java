package com.calorias.calculadora.services;

import com.calorias.calculadora.dto.PlatoDTO;
import com.calorias.calculadora.exceptionhandler.IngredientNotFound;

import java.util.List;

public interface MenuService {

    PlatoDTO calcularCalorias(PlatoDTO plato) throws IngredientNotFound;
    List<PlatoDTO> calcularCaloriasMenu(List<PlatoDTO> platos) throws IngredientNotFound;
}

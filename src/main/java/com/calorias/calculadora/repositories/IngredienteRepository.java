package com.calorias.calculadora.repositories;

import com.calorias.calculadora.dto.IngredienteDTO;
import com.calorias.calculadora.exceptionhandler.IngredientNotFound;

import java.util.List;

public interface IngredienteRepository {
     void getIngredientes(List<IngredienteDTO> ingredientes) throws IngredientNotFound;
}

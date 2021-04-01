package com.calorias.calculadora.controllers;

import com.calorias.calculadora.dto.ErrorDTO;
import com.calorias.calculadora.dto.PlatoDTO;
import com.calorias.calculadora.exceptionhandler.IngredientNotFound;
import com.calorias.calculadora.services.PlatoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plato")
public class PlatoController {

    @Autowired
    private PlatoServiceImpl platoService;

    @PostMapping("/calcularcalorias")
    public ResponseEntity<PlatoDTO> calcularCalorias(@RequestBody PlatoDTO plato) throws IngredientNotFound {
        this.platoService.calcularCalorias(plato);
        return ResponseEntity.ok(plato);
    }

    @PostMapping("/calcularcaloriasmenu")
    public ResponseEntity<List<PlatoDTO>> calcularCaloriasMenu(@RequestBody List<PlatoDTO> platos) throws IngredientNotFound {
        this.platoService.calcularCaloriasMenu(platos);
        return ResponseEntity.ok(platos);
    }

    @ExceptionHandler(IngredientNotFound.class)
    public ResponseEntity<ErrorDTO> handleException(IngredientNotFound errorException) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName("Ingrediete Invalido");
        errorDTO.setDescription("El Ingrediente " + errorException.getMessage() + " es invalido");
        return ResponseEntity.badRequest().body(errorDTO);
    }
}

package com.calorias.calculadora.controllers;

import com.calorias.calculadora.dto.PlatoDTO;
import com.calorias.calculadora.services.PlatoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/plato")
public class PlatoController {

    @Autowired
    private PlatoServiceImpl platoService;

    @PostMapping("/calcularcalorias")
    public PlatoDTO calcularCalorias(@RequestBody PlatoDTO plato){
        this.platoService.calcularCalorias(plato);
        return plato;
    }

    @PostMapping("/calcularcaloriasmenu")
    public List<PlatoDTO> calcularCaloriasMenu(@RequestBody List<PlatoDTO> platos){
        this.platoService.calcularCaloriasMenu(platos);
        return platos;
    }
}

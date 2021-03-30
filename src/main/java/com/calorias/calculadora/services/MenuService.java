package com.calorias.calculadora.services;

import com.calorias.calculadora.dto.PlatoDTO;

import java.util.List;

public interface MenuService {

    PlatoDTO calcularCalorias(PlatoDTO plato);
    List<PlatoDTO> calcularCaloriasMenu(List<PlatoDTO> platos);
}

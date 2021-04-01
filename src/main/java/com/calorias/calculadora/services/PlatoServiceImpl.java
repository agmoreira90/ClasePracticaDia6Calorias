package com.calorias.calculadora.services;

import com.calorias.calculadora.dto.IngredienteDTO;
import com.calorias.calculadora.dto.PlatoDTO;
import com.calorias.calculadora.exceptionhandler.IngredientNotFound;
import com.calorias.calculadora.repositories.IngredienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoServiceImpl implements MenuService {

    private final IngredienteRepository ingrediente;

    public PlatoServiceImpl(IngredienteRepository ingrediente) {
        this.ingrediente = ingrediente;
    }

    @Override
    public PlatoDTO calcularCalorias(PlatoDTO plato) throws IngredientNotFound {
        this.ingrediente.getIngredientes(plato.getIngredients());
        Double caloreias = 0.0;
        IngredienteDTO moreCaloriesIngredient = null;
        for (int i = 0; i < plato.getIngredients().size(); i++) {
            caloreias += plato.getIngredients().get(i).getCalories() * plato.getIngredients().get(i).getWeight();
            if (moreCaloriesIngredient == null || moreCaloriesIngredient.getCalories() < plato.getIngredients().get(i).getCalories()) {
                moreCaloriesIngredient = plato.getIngredients().get(i);
            }
        }
        plato.setMoreCaloriesIngredient(moreCaloriesIngredient);
        plato.setCalories(caloreias);
        return plato;
    }

    public List<PlatoDTO> calcularCaloriasMenu(List<PlatoDTO> platos) throws IngredientNotFound {
        for (int i = 0; i < platos.size(); i++) {
            calcularCalorias(platos.get(i));
        }
        return platos;
    }
}

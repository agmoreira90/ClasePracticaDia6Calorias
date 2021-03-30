package com.calorias.calculadora.repositories;

import com.calorias.calculadora.dto.IngredienteDTO;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredienteRepositoryImpl implements IngredienteRepository{
    @Override
    public void getIngredientes(List<IngredienteDTO>  ingredientes) {
        List<IngredienteDTO> ingredientesDTO = null;
        ingredientesDTO = cargarBase();
        if (ingredientesDTO != null) {
            for (int i = 0; i < ingredientes.size(); i++) {
                int finalI = i;
                Optional<IngredienteDTO> item = ingredientesDTO.stream().filter(ingredienteDTO -> ingredienteDTO.getName().equals(ingredientes.get(finalI).getName())).findFirst();
                if (item.isPresent()) {
                    ingredientes.get(i).setCalories(item.get().getCalories());
                }
            }
        }
    }

    private List<IngredienteDTO> cargarBase() {
        File file = null;
        List<IngredienteDTO> preciosDTO = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<List<IngredienteDTO>> typeRef = new TypeReference<List<IngredienteDTO>>() {
            };
            preciosDTO = objectMapper.readValue(file, typeRef);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return preciosDTO;
    }
}

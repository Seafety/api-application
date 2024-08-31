package com.softtek_preview.api_application.service;

import com.softtek_preview.api_application.domain.cost.Cost;
import com.softtek_preview.api_application.domain.cost.CostRequestDTO;
import com.softtek_preview.api_application.domain.cost.CostResponseDTO;
import com.softtek_preview.api_application.exceptions.ResourceNotFoundException;
import com.softtek_preview.api_application.repositories.CostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CostService {

    @Autowired
    private CostRepository costRepository;

    public CostResponseDTO createCost(CostRequestDTO costRequestDTO) {
        Cost cost = convertToEntity(costRequestDTO);
        Cost savedCost = costRepository.save(cost);
        return null;
    }

    public CostResponseDTO getCostById(String id){
        Cost cost = costRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cost not found"));
        return convertToDTO(cost);
    }

    public List<CostResponseDTO> getAllCosts(){
        return costRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private Cost convertToEntity(CostRequestDTO costRequestDTO) {
        Cost cost = new Cost();
        cost.setCategoria(costRequestDTO.categoria());
        cost.setExercicio(costRequestDTO.exercicio());
        cost.setPeriodo(costRequestDTO.exercicio());
        cost.setValorAt(costRequestDTO.valorAt());
        cost.setCodigoAt(costRequestDTO.codigoAt());
        return cost;
    }

    private CostResponseDTO convertToDTO(Cost cost) {
        return new CostResponseDTO(
                cost.getExercicio(),
                cost.getPeriodo(),
                cost.getCodigoAt(),
                cost.getCategoria(),
                cost.getValorAt()
        );
    }
}

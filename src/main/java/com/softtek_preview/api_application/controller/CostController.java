package com.softtek_preview.api_application.controller;

import com.softtek_preview.api_application.domain.cost.CostRequestDTO;
import com.softtek_preview.api_application.domain.cost.CostResponseDTO;
import com.softtek_preview.api_application.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cost")
public class CostController {

    @Autowired
    private CostService costService;

    @PostMapping
    public ResponseEntity<CostResponseDTO> createCost(CostRequestDTO costRequestDTO){
        CostResponseDTO cost = costService.createCost(costRequestDTO);
        return ResponseEntity.ok(cost);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CostResponseDTO> getCostById(@PathVariable String id){
        CostResponseDTO cost = costService.getCostById(id);
        return ResponseEntity.ok(cost);
    }

    @GetMapping
    public ResponseEntity<List<CostResponseDTO>> getAllCosts(){
        List<CostResponseDTO> costs =  costService.getAllCosts();
        return ResponseEntity.ok(costs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CostResponseDTO> updateCost(@PathVariable String codigo_at, @RequestBody CostRequestDTO costRequestDTO){
        CostResponseDTO cost = costService.updateCost(codigo_at, costResquestDTO);
        return ResponseEntity.ok(cost);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CostResponseDTO> deleteCost(@PathVariable String codigo_at){
        CostResponseDTO cost = costService.deleteCost(codigo_at);
        return ResponseEntity.noContent().build();
    }
}

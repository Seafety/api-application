package com.softtek_preview.api_application.controller;

import com.softtek_preview.api_application.domain.consultant.ConsultantRequestDTO;
import com.softtek_preview.api_application.domain.consultant.ConsultantResponseDTO;
import com.softtek_preview.api_application.service.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/consultants")
public class ConsultantController {

    @Autowired
    private ConsultantService consultantService;

    @PostMapping
    public ResponseEntity<ConsultantResponseDTO> createConsultant(@RequestBody ConsultantRequestDTO consultantRequestDTO) {
        ConsultantResponseDTO createdConsultant = consultantService.createConsultant(consultantRequestDTO);
        return ResponseEntity.status(201).body(createdConsultant);
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<ConsultantResponseDTO>> createConsultantsInBulk(@RequestBody List<ConsultantRequestDTO> consultantRequestDTOs) {
        List<ConsultantResponseDTO> createdConsultants = consultantService.createConsultantsInBulk(consultantRequestDTOs);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdConsultants);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultantResponseDTO> getConsultantById(@PathVariable UUID id) {
        ConsultantResponseDTO consultantResponseDTO = consultantService.getConsultantById(id);
        return ResponseEntity.ok(consultantResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<ConsultantResponseDTO>> getAllConsultants() {
        List<ConsultantResponseDTO> consultants = consultantService.getAllConsultants();
        return ResponseEntity.ok(consultants);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultantResponseDTO> updateConsultant(
            @PathVariable UUID id, @RequestBody ConsultantRequestDTO consultantRequestDTO) {
        ConsultantResponseDTO updatedConsultant = consultantService.updateConsultant(id, consultantRequestDTO);
        return ResponseEntity.ok(updatedConsultant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsultant(@PathVariable UUID id) {
        consultantService.deleteConsultant(id);
        return ResponseEntity.noContent().build();
    }
}

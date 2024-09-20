package com.softtek_preview.api_application.service;

import com.softtek_preview.api_application.domain.consultant.Consultant;
import com.softtek_preview.api_application.domain.consultant.ConsultantRequestDTO;
import com.softtek_preview.api_application.domain.consultant.ConsultantResponseDTO;
import com.softtek_preview.api_application.domain.cost.Cost;
import com.softtek_preview.api_application.domain.cost.CostResponseDTO;
import com.softtek_preview.api_application.exceptions.ResourceNotFoundException;
import com.softtek_preview.api_application.repositories.ConsultantRepository;
import com.softtek_preview.api_application.repositories.CostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ConsultantService {
    @Autowired
    private ConsultantRepository consultantRepository;

    @Autowired
    private CostService costService;

    @Autowired
    private CostRepository costRepository;

    public ConsultantResponseDTO createConsultant(ConsultantRequestDTO consultantRequestDTO) {
        Consultant consultant = convertToEntity(consultantRequestDTO);
        Consultant savedConsultant = consultantRepository.save(consultant);
        return convertToDTO(savedConsultant);
    }

    public List<ConsultantResponseDTO> createConsultantsInBulk(List<ConsultantRequestDTO> consultantRequestDTOs) {
        List<Consultant> consultants = consultantRequestDTOs.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());

        List<Consultant> savedConsultants = consultantRepository.saveAll(consultants);

        return savedConsultants.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ConsultantResponseDTO getConsultantById(UUID id) {
        Consultant consultant = consultantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consultant not found"));
        return convertToDTO(consultant);
    }

    public List<ConsultantResponseDTO> getAllConsultants() {
        return consultantRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ConsultantResponseDTO updateConsultant(UUID id, ConsultantRequestDTO consultantRequestDTO) {
        Consultant consultant = consultantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consultant not found"));
        updateFromDTO(consultant, consultantRequestDTO);
        Consultant updatedConsultant = consultantRepository.save(consultant);
        return convertToDTO(updatedConsultant);
    }



    public void deleteConsultant(UUID id) {
        Consultant consultant = consultantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consultant not found"));
        consultantRepository.delete(consultant);
    }

    private Consultant convertToEntity(ConsultantRequestDTO dto) {
        Consultant consultant = new Consultant();
        consultant.setNome(dto.nome());
        consultant.setCodigoAt(dto.codigoAt());
        consultant.setDescricaoAt(dto.descricaoAt());
        consultant.setSenioridade(dto.senioridade());
        consultant.setEspecialidade(dto.especialidade());
        consultant.setAusenciaIni(dto.ausenciaIni());
        consultant.setAusenciaFin(dto.ausenciaFin());
        consultant.setAusenciaTipo(dto.ausenciaTipo());
        Cost cost = costRepository.findById(dto.codigoAt())
                .orElseThrow(() -> new ResourceNotFoundException("Cost not found for codigoAt: " + dto.codigoAt()));
        consultant.setCost(cost);

        return consultant;
    }

    private ConsultantResponseDTO convertToDTO(Consultant consultant) {
        CostResponseDTO costResponseDTO = costService.convertToDTO(consultant.getCost());
        return new ConsultantResponseDTO(
                consultant.getId(),
                consultant.getNome(),
                consultant.getCodigoAt(),
                consultant.getDescricaoAt(),
                consultant.getSenioridade(),
                consultant.getEspecialidade(),
                consultant.getAusenciaIni(),
                consultant.getAusenciaFin(),
                consultant.getAusenciaTipo(),
                costResponseDTO
        );
    }

    private void updateFromDTO(Consultant consultant, ConsultantRequestDTO dto) {
        consultant.setNome(dto.nome());
        consultant.setCodigoAt(dto.codigoAt());
        consultant.setDescricaoAt(dto.descricaoAt());
        consultant.setSenioridade(dto.senioridade());
        consultant.setEspecialidade(dto.especialidade());
        consultant.setAusenciaIni(dto.ausenciaIni());
        consultant.setAusenciaFin(dto.ausenciaFin());
        consultant.setAusenciaTipo(dto.ausenciaTipo());
    }
}

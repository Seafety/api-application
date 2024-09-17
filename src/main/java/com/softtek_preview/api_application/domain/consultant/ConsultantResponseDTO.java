package com.softtek_preview.api_application.domain.consultant;

import com.softtek_preview.api_application.domain.cost.CostResponseDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record ConsultantResponseDTO(
        UUID id,
        String nome,
        String codigoAt,
        String descricaoAt,
        String senioridade,
        List<String> especialidade,
        LocalDate ausenciaIni,
        LocalDate ausenciaFin,
        String ausenciaTipo,
        CostResponseDTO cost
) {
}

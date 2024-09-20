package com.softtek_preview.api_application.domain.ticket;

import java.time.LocalDate;
import java.util.UUID;

public record TicketRequestDTO(
        UUID projetoId,
        int chamado,
        LocalDate dtAberturaChamado,
        String moduloChamado,
        String tipoChamado,
        String statusChamado,
        UUID consultantId,
        String moduloConsultor,
        int exercicio,
        int periodo,
        int dia,
        int horas,
        String tipoHoras,
        String complexidade
) {
}

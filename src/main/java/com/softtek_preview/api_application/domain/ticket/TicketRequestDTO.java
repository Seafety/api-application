package com.softtek_preview.api_application.domain.ticket;

import java.time.LocalDate;

public record TicketRequestDTO(
        Long id,
        Long projetoId,
        String projetoNome,
        int chamado,
        LocalDate dtAberturaChamado,
        String moduloChamado,
        String tipoChamado,
        String statusChamado,
        Long consultantId,
        String consultantNome,
        String moduloConsultor,
        int exercicio,
        int periodo,
        int dia,
        int horas,
        String tipoHoras,
        String complexidade
) {
}

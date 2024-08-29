package com.softtek_preview.api_application.domain.cost;

import java.math.BigDecimal;

public record CostRequestDTO(
        int exercicio,
        int periodo,
        String codigoAt,
        String categoria,
        BigDecimal valorAt
) {
}

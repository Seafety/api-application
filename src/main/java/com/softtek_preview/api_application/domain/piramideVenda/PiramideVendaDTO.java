package com.softtek_preview.api_application.domain.piramideVenda;

import java.math.BigDecimal;

public record PiramideVendaDTO(
        BigDecimal expert,
        BigDecimal senior,
        BigDecimal pleno,
        BigDecimal junior,
        BigDecimal estagiario,
        BigDecimal gestao
) {
}

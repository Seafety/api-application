package com.softtek_preview.api_application.domain.custoVenda;

import java.math.BigDecimal;

public record CustoVendaDTO(
        BigDecimal expert,
        BigDecimal senior,
        BigDecimal pleno,
        BigDecimal junior,
        BigDecimal estagiario,
        BigDecimal gestao
) {
}

package com.softtek_preview.api_application.domain.custoVenda;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustoVenda {

    @Column(name = "expert_custo", nullable = false)
    private BigDecimal expert;

    @Column(name = "senior_custo", nullable = false)
    private BigDecimal senior;

    @Column(name = "pleno_custo", nullable = false)
    private BigDecimal pleno;

    @Column(name = "junior_custo", nullable = false)
    private BigDecimal junior;

    @Column(name = "estagiario_custo", nullable = false)
    private BigDecimal estagiario;

    @Column(name = "gestao_custo", nullable = false)
    private BigDecimal gestao;
}

package com.softtek_preview.api_application.domain.piramideVenda;

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
public class PiramideVenda {

    @Column(name = "expert_piramide", nullable = false)
    private BigDecimal expert;

    @Column(name = "senior_piramide", nullable = false)
    private BigDecimal senior;

    @Column(name = "pleno_piramide", nullable = false)
    private BigDecimal pleno;

    @Column(name = "junior_piramide", nullable = false)
    private BigDecimal junior;

    @Column(name = "estagiario_piramide", nullable = false)
    private BigDecimal estagiario;

    @Column(name = "gestao_piramide", nullable = false)
    private BigDecimal gestao;
}

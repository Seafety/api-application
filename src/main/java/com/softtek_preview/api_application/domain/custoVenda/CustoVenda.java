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

    @Column(name = "expert", nullable = false)
    private BigDecimal expert;

    @Column(name = "senior", nullable = false)
    private BigDecimal senior;

    @Column(name = "pleno", nullable = false)
    private BigDecimal pleno;

    @Column(name = "junior", nullable = false)
    private BigDecimal junior;

    @Column(name = "estagiario", nullable = false)
    private BigDecimal estagiario;

    @Column(name = "gestao", nullable = false)
    private BigDecimal gestao;
}

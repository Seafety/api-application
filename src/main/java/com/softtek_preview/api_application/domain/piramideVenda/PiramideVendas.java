package com.softtek_preview.api_application.domain.piramideVenda;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PiramideVendas {

    @Column(name = "expert_piramide", nullable = false)
    private double expert;

    @Column(name = "senior_piramide", nullable = false)
    private double senior;

    @Column(name = "pleno_piramide", nullable = false)
    private double pleno;

    @Column(name = "junior_piramide", nullable = false)
    private double junior;

    @Column(name = "estagiario_piramide", nullable = false)
    private double estagiario;
}

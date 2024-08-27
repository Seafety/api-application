package com.softtek_preview.api_application.domain.cost;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Table(name = "costs")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cost {

    @Column(name = "exercicio", nullable = false)
    private int exercicio;

    @Column(name = "periodo", nullable = false)
    private int periodo;

    @Id
    @Column(name = "codigo_at", nullable = false)
    private String codigoAt;

    @Column(name = "categoria", nullable = false)
    private String categoria;

    @Column(name = "valor_at", nullable = false)
    private BigDecimal valorAt;
}
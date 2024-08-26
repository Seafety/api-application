package com.softtek_preview.api_application.domain.project;

import com.softtek_preview.api_application.domain.custoVenda.CustoVenda;
import com.softtek_preview.api_application.domain.piramideVenda.PiramideVendas;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Table(name = "project")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "projeto", nullable = false)
    private String projeto;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "tipo_contrato", nullable = false)
    private String tipoContrato;

    @ElementCollection
    @CollectionTable(name = "project_modulo", joinColumns = @JoinColumn(name = "project_id"))
    @Column(name = "modulo")
    private List<String> modulo;

    @ElementCollection
    @CollectionTable(name = "project_tipo_demanda", joinColumns = @JoinColumn(name = "project_id"))
    @Column(name = "tipo_demanda")
    private List<String> tipoDemanda;

    @Column(name = "baseline", nullable = false)
    private int baseline;

    @Column(name = "valor_contrato", nullable = false)
    private BigDecimal valorContrato;

    @Embedded
    private PiramideVendas piramideVendas;

    @Embedded
    private CustoVenda custoVenda;

    @Column(name = "horas_gestao", nullable = false)
    private int horasGestao;

    @Column(name = "baseline_consumido", nullable = false)
    private int baselineConsumido;

    @Column(name = "inicio_contrato", nullable = false)
    private LocalDate inicioContrato;

    @Column(name = "fim_contrato", nullable = false)
    private LocalDate fimContrato;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "ativo", nullable = false)
    private boolean ativo;
}

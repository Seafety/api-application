package com.softtek_preview.api_application.domain.ticket;

import com.softtek_preview.api_application.domain.consultant.Consultant;
import com.softtek_preview.api_application.domain.project.Project;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "ticket")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "projeto_id", referencedColumnName = "id", nullable = false)
    private Project projeto;

    @Column(name = "chamado", nullable = false)
    private int chamado;

    @Column(name = "dt_abertura_chamado", nullable = false)
    private LocalDate dtAberturaChamado;

    @Column(name = "modulo_chamado", nullable = false)
    private String moduloChamado;

    @Column(name = "tipo_chamado", nullable = false)
    private String tipoChamado;

    @Column(name = "status_chamado", nullable = false)
    private String statusChamado;

    @ManyToOne
    @JoinColumn(name = "consultant_id", referencedColumnName = "id", nullable = false)
    private Consultant consultant;

    @Column(name = "modulo_consultor", nullable = false)
    private String moduloConsultor;

    @Column(name = "exercicio", nullable = false)
    private int exercicio;

    @Column(name = "periodo", nullable = false)
    private int periodo;

    @Column(name = "dia", nullable = false)
    private int dia;

    @Column(name = "horas", nullable = false)
    private int horas;

    @Column(name = "tipo_horas", nullable = false)
    private String tipoHoras;

    @Column(name = "complexidade", nullable = false)
    private String complexidade;
}

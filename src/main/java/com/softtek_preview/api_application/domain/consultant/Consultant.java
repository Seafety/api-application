package com.softtek_preview.api_application.domain.consultant;

import com.softtek_preview.api_application.domain.cost.Cost;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Table(name = "consultants")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Consultant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is", nullable = false)
    private String is;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "codigo_at", nullable = false)
    private String codigoAt;

    @Column(name = "descricao_at", nullable = false)
    private String descricaoAt;

    @Column(name = "senioridade", nullable = false)
    private String senioridade;

    @ElementCollection
    @CollectionTable(name = "consultant_especialidade", joinColumns = @JoinColumn(name = "consultant_id"))
    @Column(name = "especialidade")
    private List<String> especialidade;

    @Column(name = "ausencia_ini")
    private LocalDate ausenciaIni;

    @Column(name = "ausencia_fin")
    private LocalDate ausenciaFin;

    @Column(name = "ausencia_tipo")
    private String ausenciaTipo;

    @ManyToOne
    @JoinColumn(name = "codigo_at", referencedColumnName = "codigo_at", insertable = false, updatable = false)
    private Cost cost;
}

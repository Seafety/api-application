package com.softtek_preview.api_application.domain.project;

import com.softtek_preview.api_application.domain.custoVenda.CustoVendaRequestDTO;
import com.softtek_preview.api_application.domain.piramideVenda.PiramideVendasRequestDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
public record ProjectResquestDTO(
        String projeto,
        String descricao,
        String tipoContrato,
        List<String> modulo,
        List<String> tipoDemanda,
        int baseline,
        BigDecimal valorContrato,
        PiramideVendasRequestDTO piramideVendas,
        CustoVendaRequestDTO custoVenda,
        int horasGestao,
        int baselineConsumido,
        LocalDate inicioContrato,
        LocalDate fimContrato,
        String status,
        boolean ativo
) { }

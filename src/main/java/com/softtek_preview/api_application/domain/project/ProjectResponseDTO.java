package com.softtek_preview.api_application.domain.project;

import com.softtek_preview.api_application.domain.custoVenda.CustoVendaDTO;
import com.softtek_preview.api_application.domain.piramideVenda.PiramideVendaDTO;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record ProjectResponseDTO(
        UUID id,
        String projeto,
        String descricao,
        String tipoContrato,
        List<String> modulo,
        List<String> tipoDemanda,
        int baseline,
        BigDecimal valorContrato,
        PiramideVendaDTO piramideVendas,
        CustoVendaDTO custoVenda,
        int horasGestao,
        int baselineConsumido,
        LocalDate inicioContrato,
        LocalDate fimContrato,
        String status,
        boolean ativo
) {
}

package com.softtek_preview.api_application.domain.project;


import com.softtek_preview.api_application.domain.custoVenda.CustoVendaDTO;
import com.softtek_preview.api_application.domain.piramideVenda.PiramideVendaDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;


public record ProjectRequestDTO(
        @NotNull(message = "O nome do projeto é obrigatório")
        @Size(min = 1, max = 255, message = "O nome do projeto deve ter entre 1 e 255 caracteres")
        String projeto,

        @NotNull(message = "A descrição é obrigatória")
        @Size(min = 1, max = 255, message = "A descrição deve ter entre 1 e 255 caracteres")
        String descricao,

        Set<UUID> owners,

        @NotNull(message = "O tipo de contrato é obrigatório")
        String tipoContrato,

        @NotNull(message = "O módulo é obrigatório")
        List<String> modulo,

        @NotNull(message = "O tipo de demanda é obrigatório")
        List<String> tipoDemanda,

        @NotNull(message = "O baseline é obrigatório")
        int baseline,

        @NotNull(message = "O valor do contrato é obrigatório")
        BigDecimal valorContrato,

        @NotNull(message = "A pirâmide de vendas é obrigatória")
        PiramideVendaDTO piramideVendas,

        @NotNull(message = "O custo de venda é obrigatório")
        CustoVendaDTO custoVenda,

        @NotNull(message = "As horas de gestão são obrigatórias")
        int horasGestao,

        @NotNull(message = "O baseline consumido é obrigatório")
        int baselineConsumido,

        @NotNull(message = "A data de início do contrato é obrigatória")
        LocalDate inicioContrato,

        @NotNull(message = "A data de fim do contrato é obrigatória")
        LocalDate fimContrato,

        @NotNull(message = "O status é obrigatório")
        String status,

        @NotNull(message = "O campo ativo é obrigatório")
        boolean ativo
) { }

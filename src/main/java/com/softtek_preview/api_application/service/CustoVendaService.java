package com.softtek_preview.api_application.service;

import com.softtek_preview.api_application.domain.custoVenda.CustoVenda;
import com.softtek_preview.api_application.domain.custoVenda.CustoVendaDTO;
import org.springframework.stereotype.Service;

@Service
public class CustoVendaService {

    public CustoVenda convertToEntity(CustoVendaDTO dto) {
        if (dto == null) {
            return null;
        }
        CustoVenda custoVenda = new CustoVenda();
        custoVenda.setExpert(dto.expert());
        custoVenda.setSenior(dto.senior());
        custoVenda.setPleno(dto.pleno());
        custoVenda.setJunior(dto.junior());
        custoVenda.setEstagiario(dto.estagiario());
        custoVenda.setGestao(dto.gestao());
        return custoVenda;
    }

    public CustoVendaDTO convertToDTO(CustoVenda custoVenda) {
        if (custoVenda == null) {
            return null;
        }
        return new CustoVendaDTO(
                custoVenda.getExpert(),
                custoVenda.getSenior(),
                custoVenda.getPleno(),
                custoVenda.getJunior(),
                custoVenda.getEstagiario(),
                custoVenda.getGestao()
        );
    }
}

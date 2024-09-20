package com.softtek_preview.api_application.service;

import com.softtek_preview.api_application.domain.piramideVenda.PiramideVenda;
import com.softtek_preview.api_application.domain.piramideVenda.PiramideVendaDTO;
import org.springframework.stereotype.Service;

@Service
public class PiramideVendasService {

    public PiramideVenda convertToEntity(PiramideVendaDTO dto) {
        if (dto == null) {
            return null;
        }
        PiramideVenda piramideVenda = new PiramideVenda();
        piramideVenda.setExpert(dto.expert());
        piramideVenda.setSenior(dto.senior());
        piramideVenda.setPleno(dto.pleno());
        piramideVenda.setJunior(dto.junior());
        piramideVenda.setEstagiario(dto.estagiario());
        piramideVenda.setGestao(dto.gestao());
        return piramideVenda;
    }

    public PiramideVendaDTO convertToDTO(PiramideVenda piramideVenda) {
        if (piramideVenda == null) {
            return null;
        }
        return new PiramideVendaDTO(
                piramideVenda.getExpert(),
                piramideVenda.getSenior(),
                piramideVenda.getPleno(),
                piramideVenda.getJunior(),
                piramideVenda.getEstagiario(),
                piramideVenda.getGestao()
        );
    }
}

package com.rd.treinamentodev.AvaliacaoSpringBoot.service.bo;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.InstrutorDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.InstrutorEntity;
import org.springframework.stereotype.Component;

@Component
public class InstrutorBO {
    public InstrutorDTO parseDTO (InstrutorEntity entity){
        InstrutorDTO dto = new InstrutorDTO();
        dto.setNome(entity.getNomeInstrutor());
        dto.setValorHora(entity.getValorHora());
        return dto;
    }
}

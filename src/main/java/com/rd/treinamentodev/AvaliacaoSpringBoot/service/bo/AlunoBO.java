package com.rd.treinamentodev.AvaliacaoSpringBoot.service.bo;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.AlunoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.AlunoEntity;
import org.springframework.stereotype.Component;

@Component
public class AlunoBO {
    public AlunoDTO parseDTO(AlunoEntity entity){
        AlunoDTO dto = new AlunoDTO();
        dto.setNome(entity.getNomeAluno());
        dto.setCpf(entity.getCpf());
        return dto;
    }
}

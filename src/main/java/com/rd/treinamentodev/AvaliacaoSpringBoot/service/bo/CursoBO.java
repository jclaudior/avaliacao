package com.rd.treinamentodev.AvaliacaoSpringBoot.service.bo;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import org.springframework.stereotype.Component;

@Component
public class CursoBO {
    public CursoEntity parseEntity (CursoDTO dto){
        CursoEntity entity = new CursoEntity();
        entity.setNomeCurso(dto.getNome());
        entity.setNrCargaHoraria(dto.getCargaHoraria());

        return entity;
    }

    public CursoDTO parseDTO (CursoEntity entity){
        CursoDTO dto = new CursoDTO();
        dto.setNome(entity.getNomeCurso());
        dto.setCargaHoraria(entity.getNrCargaHoraria());

        return dto;
    }
}

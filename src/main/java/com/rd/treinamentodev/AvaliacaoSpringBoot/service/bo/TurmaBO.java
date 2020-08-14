package com.rd.treinamentodev.AvaliacaoSpringBoot.service.bo;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.AlunoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.InstrutorDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.TurmaDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.AlunoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.InstrutorEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.TurmaEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class TurmaBO {
    @Autowired
    CursoBO cursoBO;

    @Autowired
    InstrutorBO instrutorBO;

    @Autowired
    AlunoBO alunoBO;

    public TurmaDTO parseDTO (TurmaEntity entity){
        TurmaDTO dto = new TurmaDTO();
        dto.setCurso(cursoBO.parseDTO(entity.getCurso()));
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dto.setDtInicio(dateFormat.format(entity.getDtInicio()));
        dto.setDtFim(dateFormat.format(entity.getDtFinal()));
        List<InstrutorDTO> instrutores = new ArrayList<>();
        for (InstrutorEntity instrutor: entity.getInstrutores()) {
            instrutores.add(instrutorBO.parseDTO(instrutor));
        }
        dto.setInstrutores(instrutores);
        List<AlunoDTO> alunos = new ArrayList<>();
        for (AlunoEntity aluno: entity.getAlunos()) {
            alunos.add(alunoBO.parseDTO(aluno));
        }
        dto.setAlunos(alunos);

        return dto;
    }
}

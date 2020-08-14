package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.AlunoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.ResultData;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.AlunoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;


    public ResponseEntity gravar(AlunoDTO alunoDTO){
        ResultData resultData = null;
        if(alunoRepository.findByCpf(alunoDTO.getCpf()).size() > 0){
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Aluno com este CPF ja cadastrado na base de dados");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
        AlunoEntity entity = new AlunoEntity();
        entity.setNomeAluno(alunoDTO.getNome());
        entity.setCpf(alunoDTO.getCpf());
        entity = alunoRepository.save(entity);
        resultData = new ResultData(HttpStatus.CREATED.value(), "Aluno cadastrado com sucesso", entity.getIdAluno());
        return ResponseEntity.status(HttpStatus.CREATED).body(resultData);



    }
}

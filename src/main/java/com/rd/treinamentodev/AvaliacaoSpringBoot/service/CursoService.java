package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.CursoRepository;
import com.rd.treinamentodev.AvaliacaoSpringBoot.service.bo.CursoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    CursoBO bo;

    @Autowired
    CursoRepository repository;

    public ResponseEntity inserirCurso(CursoDTO cursoDTO){
        CursoEntity cursoEntity = bo.parseEntity(cursoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cursoEntity));
    }
}

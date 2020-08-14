package com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity
@Table(name="tb_modulo")
public class ModuloEntity {
    @Id
    @Column(name="id_modulo")
    private BigInteger idModulo;

    @Column(name="ds_nome")
    private String dsNome;

    @OneToOne
    @JoinColumn(name="id_instrutor")
    private InstrutorEntity instrutor;

}

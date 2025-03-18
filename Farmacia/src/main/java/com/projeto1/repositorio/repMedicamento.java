package com.projeto1.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto1.entidade.Medicamento;

public interface repMedicamento extends JpaRepository <Medicamento,Long> {

}

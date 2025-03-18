package com.projeto1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto1.entidade.Medicamento;
import com.projeto1.repositorio.repMedicamento;


@Service

public class SerMedicamento{
	private final repMedicamento repMedicamento;
	
	@Autowired
	public SerMedicamento (final repMedicamento repMedicamento) {
		this.repMedicamento=repMedicamento;
	}
	
	public List<Medicamento>getAllMedicamento(){
		return repMedicamento.findAll();
	}
	public Medicamento getMedicamentoById(final Long id) {
		Optional <Medicamento>Medicamento=repMedicamento.findById(id);
		return Medicamento.orElse(null);
	}
	
	public Medicamento saveMedicamento(Medicamento Medicamento) {
		return repMedicamento.save(Medicamento);
	}
	
	public Medicamento updateMedicamento(Long id, Medicamento updateMedicamento) {
		Optional<Medicamento> existingMedicamento=repMedicamento.findById(id);
		if(existingMedicamento.isPresent()) {
			updateMedicamento.setId(id);
			return repMedicamento.save(updateMedicamento);
		}
		return null;
	}
	
	public boolean deleteMedicamento(Long id) {
		Optional<Medicamento>existingMedicamento=repMedicamento.findById(id);
		if(existingMedicamento.isPresent()) {
			
			repMedicamento.deleteById(id);
			return true;
		}
		return false;
	}

}

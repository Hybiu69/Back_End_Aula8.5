package com.projeto1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto1.entidade.Farmaceutico;
import com.projeto1.repositorio.RepFarmaceutico;




@Service

public class SerFarmaceutico{
	private final RepFarmaceutico repFarmaceutico;
	
	@Autowired
	public SerFarmaceutico (final RepFarmaceutico repFarmaceutico) {
		this.repFarmaceutico=repFarmaceutico;
	}
	
	public List<Farmaceutico>getAllFarmaceutico(){
		return repFarmaceutico.findAll();
	}
	public Farmaceutico getFarmaceuticoById(final Long id) {
		Optional <Farmaceutico>Farmaceutico=repFarmaceutico.findById(id);
		return Farmaceutico.orElse(null);
	}
	
	public Farmaceutico saveFarmaceutico(Farmaceutico Farmaceutico) {
		return repFarmaceutico.save(Farmaceutico);
	}
	
	public Farmaceutico updateFarmaceutico(Long id, Farmaceutico updateFarmaceutico) {
		Optional<Farmaceutico> existingFarmaceutico=repFarmaceutico.findById(id);
		if(existingFarmaceutico.isPresent()) {
			updateFarmaceutico.setId(id);
			return repFarmaceutico.save(updateFarmaceutico);
		}
		return null;
	}
	
	public boolean deleteFarmaceutico(Long id) {
		Optional<Farmaceutico>existingFarmaceutico=repFarmaceutico.findById(id);
		if(existingFarmaceutico.isPresent()) {
			
			repFarmaceutico.deleteById(id);
			return true;
		}
		return false;
	}

}

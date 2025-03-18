package com.projeto1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto1.entidade.Drogaria;
import com.projeto1.repositorio.repDrogaria;


@Service

public class SerDrogaria{
	private final repDrogaria repDrogaria;
	
	@Autowired
	public SerDrogaria (final repDrogaria repDrogaria) {
		this.repDrogaria=repDrogaria;
	}
	
	public List<Drogaria>getAllDrogaria(){
		return repDrogaria.findAll();
	}
	public Drogaria getDrogariaById(final Long id) {
		Optional <Drogaria>Drogaria=repDrogaria.findById(id);
		return Drogaria.orElse(null);
	}
	
	public Drogaria saveDrogaria(Drogaria Drogaria) {
		return repDrogaria.save(Drogaria);
	}
	
	public Drogaria updateDrogaria(Long id, Drogaria updateDrogaria) {
		Optional<Drogaria> existingDrogaria=repDrogaria.findById(id);
		if(existingDrogaria.isPresent()) {
			updateDrogaria.setId(id);
			return repDrogaria.save(updateDrogaria);
		}
		return null;
	}
	
	public boolean deleteDrogaria(Long id) {
		Optional<Drogaria>existingDrogaria=repDrogaria.findById(id);
		if(existingDrogaria.isPresent()) {
			
			repDrogaria.deleteById(id);
			return true;
		}
		return false;
	}

}

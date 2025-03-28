package com.projeto1.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto1.entidade.Farmaceutico;
import com.projeto1.service.SerFarmaceutico;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/Farmaceutico")
public class ConFarmaceutico{
	private final SerFarmaceutico SerFarmaceutico;

	@Autowired
	public ConFarmaceutico(SerFarmaceutico SerFarmaceutico) {
		this.SerFarmaceutico=SerFarmaceutico;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Farmaceutico>getFarmaceuticoById(@PathVariable Long id){
		Farmaceutico Farmaceutico=SerFarmaceutico.getFarmaceuticoById(id);
		if(Farmaceutico!=null) {
			return ResponseEntity.ok(Farmaceutico);
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Farmaceutico>>getAllFarmaceutico(){
		List<Farmaceutico>Farmaceutico =SerFarmaceutico.getAllFarmaceutico();
		return ResponseEntity.ok(Farmaceutico);
	}
	@PostMapping("/")
	public ResponseEntity<Farmaceutico>criarFarmaceutico(@RequestBody @Valid Farmaceutico Farmaceutico){
		Farmaceutico criarFarmaceutico= SerFarmaceutico.saveFarmaceutico(Farmaceutico);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarFarmaceutico);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Farmaceutico>updateFarmaceutico(@PathVariable Long id, @RequestBody @Valid Farmaceutico Farmaceutico){
		Farmaceutico updatedFarmaceutico=SerFarmaceutico.updateFarmaceutico(id, Farmaceutico);
		if(updatedFarmaceutico!=null) {
			return ResponseEntity.ok(updatedFarmaceutico);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Farmaceutico>deleteFarmaceutico(@PathVariable Long id){
		boolean deleted=SerFarmaceutico.deleteFarmaceutico(id);
		if(deleted) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}

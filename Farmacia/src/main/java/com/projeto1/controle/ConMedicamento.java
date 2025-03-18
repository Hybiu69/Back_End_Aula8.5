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

import com.projeto1.entidade.Medicamento;
import com.projeto1.service.SerMedicamento;


@RestController
@RequestMapping("/Medicamento")
public class ConMedicamento{
	private final SerMedicamento SerMedicamento;

	@Autowired
	public ConMedicamento(SerMedicamento SerMedicamento) {
		this.SerMedicamento=SerMedicamento;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Medicamento>getMedicamentoById(@PathVariable Long id){
		Medicamento Medicamento=SerMedicamento.getMedicamentoById(id);
		if(Medicamento!=null) {
			return ResponseEntity.ok(Medicamento);
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Medicamento>>getAllMedicamento(){
		List<Medicamento>Medicamento=SerMedicamento.getAllMedicamento();
		return ResponseEntity.ok(Medicamento);
	}
	@PostMapping("/")
	public ResponseEntity<Medicamento>criarMedicamento(@RequestBody Medicamento Medicamento){
		Medicamento criarMedicamento= SerMedicamento.saveMedicamento(Medicamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarMedicamento);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Medicamento>updateMedicamento(@PathVariable Long id, @RequestBody Medicamento Medicamento){
		Medicamento updatedMedicamento=SerMedicamento.updateMedicamento(id, Medicamento);
		if(updatedMedicamento!=null) {
			return ResponseEntity.ok(updatedMedicamento);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Medicamento>deleteMedicamento(@PathVariable Long id){
		boolean deleted=SerMedicamento.deleteMedicamento(id);
		if(deleted) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}

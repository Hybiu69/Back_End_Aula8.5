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

import com.projeto1.entidade.Drogaria;
import com.projeto1.service.SerDrogaria;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/Drogaria")
public class ConDrogaria{
	private final SerDrogaria SerDrogaria;

	@Autowired
	public ConDrogaria(SerDrogaria SerDrogaria) {
		this.SerDrogaria=SerDrogaria;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Drogaria>getDrogariaById(@PathVariable Long id){
		Drogaria Drogaria=SerDrogaria.getDrogariaById(id);
		if(Drogaria!=null) {
			return ResponseEntity.ok(Drogaria);
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Drogaria>>getAllDrogaria(){
		List<Drogaria>Drogaria =SerDrogaria.getAllDrogaria();
		return ResponseEntity.ok(Drogaria);
	}
	@PostMapping("/")
	public ResponseEntity<Drogaria>criarDrogaria(@RequestBody @Valid Drogaria Drogaria){
		Drogaria criarDrogaria = SerDrogaria.saveDrogaria(Drogaria);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarDrogaria);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Drogaria>updateDrogaria(@PathVariable Long id, @RequestBody @Valid Drogaria Drogaria){
		Drogaria updatedDrogaria=SerDrogaria.updateDrogaria(id, Drogaria);
		if(updatedDrogaria !=null) {
			return ResponseEntity.ok(updatedDrogaria);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Drogaria>deleteDrogaria(@PathVariable Long id){
		boolean deleted=SerDrogaria.deleteDrogaria(id);
		if(deleted) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}

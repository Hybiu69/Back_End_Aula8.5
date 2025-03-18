package com.projeto1.entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
	@Table(name="Medicamento")
	public class Medicamento {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long Id;
		
		@NotNull
		@NotBlank
		private String nome;
		
		@NotNull
		@NotBlank
		private String bula;
		
		@NotNull
		@NotBlank
		private String dataValidade;

		public Long getId() {
			return Id;
		}

		public void setId(Long id) {
			Id = id;
		}

		public String getNome() {
			return nome;
			
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getBula() {
			return bula;
		}

		public void setBula(String bula) {
			this.bula = bula;
		}

		public String getDataValidade() {
			return dataValidade;
		}

		public void setDataValidade(String dataValidade) {
			this.dataValidade = dataValidade;
		}





}

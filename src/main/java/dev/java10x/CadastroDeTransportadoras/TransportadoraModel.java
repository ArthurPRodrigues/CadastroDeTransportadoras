package dev.java10x.CadastroDeTransportadoras;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cadastro")
public class TransportadoraModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String CNPJ;
	String nome;
	String telefone;
	String email;
	String cidade;
	String estado;

	public TransportadoraModel() {

	}

	public TransportadoraModel(String nome, String CNPJ, String telefone, String email, String cidade, String estado) {
		this.nome = nome;
		this.CNPJ = CNPJ;
		this.telefone = telefone;
		this.email = email;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public String getEstado() {
		return estado;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCNPJ(String CNPJ) {
		this.CNPJ = CNPJ;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}


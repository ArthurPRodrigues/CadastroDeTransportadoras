package dev.java10x.CadastroDeTransportadoras.Transportadoras;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

import dev.java10x.CadastroDeTransportadoras.Cotacoes.CotacoesModel;
import dev.java10x.CadastroDeTransportadoras.Documentos.DocumentoModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_transportadoras")
@NoArgsConstructor
@Data
public class TransportadoraModel {

	@Id
	@Column(name = "cnpj", length = 14, nullable = false, unique = true)
	private String cnpj;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "email")
	private String email;

	@Column(name = "cidade")
	private String cidade;

	@Column(name = "estado")
	private String estado;

	@OneToMany(mappedBy = "transportadora", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DocumentoModel> documentos;

	@OneToMany(mappedBy = "transportadora", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CotacoesModel> cotacoes;
}

package dev.java10x.CadastroDeTransportadoras.Transportadoras;

import lombok.Data;
import lombok.NoArgsConstructor;

import dev.java10x.CadastroDeTransportadoras.Cotacoes.CotacoesModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_transportadoras")
@NoArgsConstructor
@Data
public class TransportadoraModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String CNPJ;
	private String nome;
	private String telefone;
	private String email;
	private String cidade;
	private String estado;

	@ManyToOne
	@JoinColumn(name = "cotacao_id", nullable = false) //Foreign key to CotacoesModel
	private CotacoesModel cotacoes;
}

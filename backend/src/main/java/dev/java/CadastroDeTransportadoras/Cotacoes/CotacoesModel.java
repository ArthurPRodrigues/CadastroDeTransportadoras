package dev.java.CadastroDeTransportadoras.Cotacoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import dev.java.CadastroDeTransportadoras.Transportadora.TransportadoraModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cotacoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CotacoesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;

	@Column(name = "produto", nullable = false)
	private String produto;

	@Column(name = "valor_unitario", nullable = false)
	private int quantidade;

	@Column(name = "valor_total", nullable = false)
	private String estado_destino;

	@ManyToOne
	@JoinColumn(name = "cnpj_transportadora", nullable = false)
	private TransportadoraModel transportadora;
}

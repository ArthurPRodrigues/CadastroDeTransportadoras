package dev.java10x.CadastroDeTransportadoras.Cotacoes;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import dev.java10x.CadastroDeTransportadoras.Transportadoras.TransportadoraModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cotacoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CotacoesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private String produto;
	private int quantidade;
	private String estado_destino;

	@OneToMany(mappedBy = "cotacoes")
	private List<TransportadoraModel> transportadoras;
}

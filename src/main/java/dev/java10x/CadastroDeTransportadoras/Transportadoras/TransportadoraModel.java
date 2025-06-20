package dev.java10x.CadastroDeTransportadoras.Transportadoras;

import java.util.List;
import dev.java10x.CadastroDeTransportadoras.Cotacoes.CotacoesModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_transportadoras")
@NoArgsConstructor
@Data
public class TransportadoraModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "cnpj")
	private String cnpj;

	@Column(name = "nome")
	private String nome;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "email")
	private String email;

	@Column(name = "cidade")
	private String cidade;

	@Column(name = "estado")
	private String estado;

	@OneToMany(mappedBy = "transportadora", cascade = CascadeType.ALL)
	private List<CotacoesModel> cotacoes;

}

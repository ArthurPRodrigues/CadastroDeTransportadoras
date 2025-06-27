package dev.java10x.CadastroDeTransportadoras.Documentos;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

import dev.java10x.CadastroDeTransportadoras.Transportadoras.TransportadoraModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_documentos")
@Data
@NoArgsConstructor
public class DocumentoModel {

	//Nunca mmexer os atributos da tabela, ne adicionar nem remover depois que o banco tiver rodada.

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;

	@Column(name = "documento", nullable = false)
	private String tipo; // Ex: "Cartão CNPJ", "Apólice de Seguro", "Doc Sanitário"

	@Column(name = "obrigatoriedade", nullable = false)
	private Boolean obrigatorio;

	@Column(name = "data_vencimento")
	private LocalDate dataVencimento;

	@Column(name = "caminho_arquivo", nullable = false)
	private String caminhoArquivo; // path no disco ou na nuvem

	// Documentos pertencem a uma unica transportadora
	// CPJ_Transportadora é a chave estrangeira para a tabela de transportadoras
	@ManyToOne
	@JoinColumn(name = "cnpj_transportadora")
	private TransportadoraModel transportadora;
}

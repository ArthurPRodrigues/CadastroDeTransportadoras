package dev.java.CadastroDeTransportadoras.Transportadora;

import dev.java.CadastroDeTransportadoras.RegistroDocumento.RegistroDocumentoModel;
import dev.java.CadastroDeTransportadoras.Usuario.UsuarioModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_transportadoras")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransportadoraModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String cnpj;

	private String nome;
	private String estado;
	private String cidade;
	private String endereco;
	private String telefone;

	private boolean disponivelParaFrete;
	private boolean quimicosControlados;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private UsuarioModel usuario;

	@OneToMany(mappedBy = "transportadora", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RegistroDocumentoModel> registros;
}

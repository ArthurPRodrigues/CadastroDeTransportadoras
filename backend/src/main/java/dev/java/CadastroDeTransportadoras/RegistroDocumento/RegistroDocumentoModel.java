package dev.java.CadastroDeTransportadoras.RegistroDocumento;

import dev.java.CadastroDeTransportadoras.Documentos.DocumentoModel;
import dev.java.CadastroDeTransportadoras.Transportadora.TransportadoraModel;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_registros_documentos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroDocumentoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate dataRegistro;
	private LocalDate dataVencimento;
	private String status; // Ex: "VALIDO", "VENCIDO"

	@ManyToOne
	@JoinColumn(name = "documento_id")
	private DocumentoModel documento;

	@ManyToOne
	@JoinColumn(name = "transportadora_id")
	private TransportadoraModel transportadora;
}

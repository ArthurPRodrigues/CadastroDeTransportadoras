package dev.java.CadastroDeTransportadoras.Documentos;

import dev.java.CadastroDeTransportadoras.TipoDocumento.TipoDocumentoModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_documentos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nomeArquivo; // Ex: "licenca_ambiental.pdf"
	private String caminho; // Caminho local ou URL

	@ManyToOne
	@JoinColumn(name = "tipo_documento_id")
	private TipoDocumentoModel tipoDocumento;
}

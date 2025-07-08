package dev.java.CadastroDeTransportadoras.RegistroDocumento;

import dev.java.CadastroDeTransportadoras.Documentos.DocumentoModel;
import dev.java.CadastroDeTransportadoras.Documentos.DocumentoRepository;
import dev.java.CadastroDeTransportadoras.Transportadora.TransportadoraModel;
import dev.java.CadastroDeTransportadoras.Transportadora.TransportadoraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistroDocumentoService {

	private final RegistroDocumentoRepository registroDocumentoRepository;
	private final TransportadoraRepository transportadoraRepository;
	private final DocumentoRepository documentoRepository;

	public List<RegistroDocumentoModel> listarTodos() {
		return registroDocumentoRepository.findAll();
	}

	public RegistroDocumentoModel salvar(RegistroDocumentoModel registro) {
		// Buscar entidades completas pelos IDs
		TransportadoraModel transportadora = transportadoraRepository
				.findById(registro.getTransportadora().getId())
				.orElseThrow(() -> new RuntimeException("Transportadora não encontrada"));

		DocumentoModel documento = documentoRepository
				.findById(registro.getDocumento().getId())
				.orElseThrow(() -> new RuntimeException("Documento não encontrado"));

		registro.setTransportadora(transportadora);
		registro.setDocumento(documento);

		return registroDocumentoRepository.save(registro);
	}

	public void deletar(Long id) {
		registroDocumentoRepository.deleteById(id);
	}
}

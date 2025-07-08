package dev.java.CadastroDeTransportadoras.Documentos;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentoService {

	private final DocumentoRepository documentoRepository;

	public List<DocumentoModel> listarTodos() {
		return documentoRepository.findAll();
	}

	public DocumentoModel salvar(DocumentoModel documento) {
		return documentoRepository.save(documento);
	}

	public void deletar(Long id) {
		documentoRepository.deleteById(id);
	}
}

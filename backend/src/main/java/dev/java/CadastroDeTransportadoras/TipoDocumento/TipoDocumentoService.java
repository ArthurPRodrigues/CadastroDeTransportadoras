package dev.java.CadastroDeTransportadoras.TipoDocumento;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoDocumentoService {

	private final TipoDocumentoRepository tipoDocumentoRepository;

	// Listar todos os tipos de documento
	public List<TipoDocumentoModel> listarTodos() {
		return tipoDocumentoRepository.findAll();
	}

	// Buscar por ID
	public TipoDocumentoModel buscarPorId(Long id) {
		return tipoDocumentoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Tipo de documento não encontrado"));
	}

	// Criar ou atualizar tipo de documento
	public TipoDocumentoModel salvar(TipoDocumentoModel tipoDocumento) {
		return tipoDocumentoRepository.save(tipoDocumento);
	}

	// Deletar por ID
	public void deletar(Long id) {
		tipoDocumentoRepository.deleteById(id);
	}
}

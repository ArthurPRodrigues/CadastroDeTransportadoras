package dev.java.CadastroDeTransportadoras.RegistroDocumento;

import dev.java.CadastroDeTransportadoras.Transportadora.TransportadoraService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registros")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RegistroDocumentoController {

	private final RegistroDocumentoRepository registroDocumentoRepository;
	private final TransportadoraService transportadoraService;

	// 🔍 Listar todos os registros
	@GetMapping
	public List<RegistroDocumentoModel> getAll() {
		return registroDocumentoRepository.findAll();
	}

	// ➕ Criar novo registro
	@PostMapping
	public RegistroDocumentoModel create(@RequestBody RegistroDocumentoModel registro) {
		RegistroDocumentoModel saved = registroDocumentoRepository.save(registro);
		transportadoraService.atualizarDisponibilidade(saved.getTransportadora());
		return saved;
	}

	// ✏️ Atualizar registro existente
	@PutMapping("/{id}")
	public RegistroDocumentoModel update(@PathVariable Long id, @RequestBody RegistroDocumentoModel novoRegistro) {
		RegistroDocumentoModel atual = registroDocumentoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Registro não encontrado"));

		atual.setDataRegistro(novoRegistro.getDataRegistro());
		atual.setDataVencimento(novoRegistro.getDataVencimento());
		atual.setDocumento(novoRegistro.getDocumento());
		atual.setTransportadora(novoRegistro.getTransportadora());
		atual.setStatus(novoRegistro.getStatus());

		RegistroDocumentoModel updated = registroDocumentoRepository.save(atual);
		transportadoraService.atualizarDisponibilidade(updated.getTransportadora());
		return updated;
	}

	// ❌ Deletar registro
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		RegistroDocumentoModel registro = registroDocumentoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Registro não encontrado"));

		registroDocumentoRepository.deleteById(id);
		transportadoraService.atualizarDisponibilidade(registro.getTransportadora());
	}
}

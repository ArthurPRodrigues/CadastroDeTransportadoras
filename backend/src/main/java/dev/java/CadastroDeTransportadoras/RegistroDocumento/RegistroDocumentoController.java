package dev.java.CadastroDeTransportadoras.RegistroDocumento;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registros-documentos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RegistroDocumentoController {

	private final RegistroDocumentoService registroDocumentoService;

	// 🔍 Listar todos os registros
	@GetMapping
	public List<RegistroDocumentoModel> listarTodos() {
		return registroDocumentoService.listarTodos();
	}

	// ➕ Salvar novo registro
	@PostMapping
	public RegistroDocumentoModel salvar(@RequestBody RegistroDocumentoModel novoRegistro) {
		return registroDocumentoService.salvar(novoRegistro);
	}

	// ❌ Deletar por ID
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		registroDocumentoService.deletar(id);
	}
}

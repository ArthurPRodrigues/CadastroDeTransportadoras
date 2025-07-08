package dev.java.CadastroDeTransportadoras.TipoDocumento;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos-documento")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TipoDocumentoController {

	private final TipoDocumentoService tipoDocumentoService;

	// Listar todos os tipos de documento
	@GetMapping
	public List<TipoDocumentoModel> listarTodos() {
		return tipoDocumentoService.listarTodos();
	}

	// Buscar por ID
	@GetMapping("/{id}")
	public TipoDocumentoModel buscarPorId(@PathVariable Long id) {
		return tipoDocumentoService.buscarPorId(id);
	}

	// Criar novo tipo ou atualizar
	@PostMapping
	public TipoDocumentoModel salvar(@RequestBody TipoDocumentoModel tipoDocumento) {
		return tipoDocumentoService.salvar(tipoDocumento);
	}

	// Deletar por ID
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		tipoDocumentoService.deletar(id);
	}
}

package dev.java.CadastroDeTransportadoras.Documentos;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documentos")
@RequiredArgsConstructor
public class DocumentoController {

	private final DocumentoService documentoService;

	@GetMapping
	public ResponseEntity<List<DocumentoModel>> listarTodos() {
		return ResponseEntity.ok(documentoService.listarTodos());
	}

	@PostMapping
	public ResponseEntity<DocumentoModel> salvar(@RequestBody DocumentoModel documento) {
		return ResponseEntity.ok(documentoService.salvar(documento));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		documentoService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}

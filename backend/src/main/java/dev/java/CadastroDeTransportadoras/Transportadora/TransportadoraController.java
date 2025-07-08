package dev.java.CadastroDeTransportadoras.Transportadora;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transportadoras")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TransportadoraController {

	private final TransportadoraService transportadoraService;

	// 🔍 Listar todas as transportadoras
	@GetMapping
	public List<TransportadoraModel> listarTodas() {
		return transportadoraService.listarTodas();
	}

	// 🔍 Buscar por ID
	@GetMapping("/{id}")
	public TransportadoraModel buscarPorId(@PathVariable Long id) {
		return transportadoraService.buscarPorId(id);
	}

	// ➕ Criar ou atualizar uma transportadora
	@PostMapping
	public TransportadoraModel salvar(@RequestBody TransportadoraModel transportadora) {
		return transportadoraService.salvar(transportadora);
	}

	// ❌ Deletar transportadora
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		transportadoraService.deletar(id);
	}
}

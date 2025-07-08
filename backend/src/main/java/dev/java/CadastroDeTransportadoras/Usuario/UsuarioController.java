package dev.java.CadastroDeTransportadoras.Usuario;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UsuarioController {

	private final UsuarioService usuarioService;

	@PostMapping("/login")
	public ResponseEntity<UsuarioModel> login(@RequestBody LoginRequest request) {
		UsuarioModel usuario = usuarioService.autenticar(request.getEmail(), request.getSenha());

		if (usuario != null) {
			return ResponseEntity.ok(usuario);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

	@GetMapping("/usuario")
	public UsuarioModel getUsuarioAtual() {
		return usuarioService.getUsuarioMockado();
	}
}

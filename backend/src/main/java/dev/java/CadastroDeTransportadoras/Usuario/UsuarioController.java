package dev.java.CadastroDeTransportadoras.Usuario;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	private final UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@PostMapping("/login")
	public ResponseEntity<UsuarioModel> login(@RequestBody LoginRequest request) {
		UsuarioModel usuario = usuarioService.autenticar(request.getEmail(), request.getSenha());

		if (usuario != null) {
			return ResponseEntity.ok(usuario);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
}

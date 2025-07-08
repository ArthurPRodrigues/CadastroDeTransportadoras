package dev.java.CadastroDeTransportadoras.Usuario;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class AuthController {

	@PostMapping
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
		String usuarioMock = "admin";
		String senhaMock = "123456";

		if (loginRequest.getUsername().equals(usuarioMock) && loginRequest.getSenha().equals(senhaMock)) {
			return ResponseEntity.ok(new LoginResponse("token-mockado-123"));
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
		}
	}
}

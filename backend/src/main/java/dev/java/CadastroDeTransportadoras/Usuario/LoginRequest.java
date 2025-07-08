package dev.java.CadastroDeTransportadoras.Usuario;

import lombok.Data;

@Data
public class LoginRequest {
	private String username;
	private String senha;

	public String getEmail() {
		return username;
	}
}

package dev.java.CadastroDeTransportadoras.Usuario;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	@Value("${mock.email}")
	private String mockEmail;

	@Value("${mock.senha}")
	private String mockSenha;


	public UsuarioModel autenticar(String email, String senha) {
		if (mockEmail.equals(email) && mockSenha.equals(senha)) {
			UsuarioModel usuario = new UsuarioModel();
			usuario.setId(1L);
			usuario.setNome("Usuário Mockado");
			usuario.setEmail(mockEmail);
			return usuario;
		}
		return null;
	}

	public UsuarioModel getUsuarioMockado() {
		return autenticar(mockEmail, mockSenha);
	}
}

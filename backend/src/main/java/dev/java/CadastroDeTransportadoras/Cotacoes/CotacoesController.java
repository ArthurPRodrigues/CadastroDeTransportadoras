package dev.java.CadastroDeTransportadoras.Cotacoes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class CotacoesController {

	@GetMapping("/cotacoes")
	public String getCotacoes() {
		return "Lista de Cotações";
	}
}
